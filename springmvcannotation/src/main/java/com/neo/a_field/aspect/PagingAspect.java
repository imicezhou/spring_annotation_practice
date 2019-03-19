package com.neo.a_field.aspect;

import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


/**
 * 开启分页的切面
 * @author Neo
 *
 */
@Aspect
public class PagingAspect {

	private final Integer defaultPageSize = 3;
	
	private final Integer defaultPageNum  = 1;
	
	/**
	 * 只切方法名以 ByCriteriaWithPaging结尾的方法
	 */
	@Pointcut(value="execution(* *ByCriteriaWithPaging(..))")
	public void pointCut() {};
	
	@Around("pointCut()")
	public Page<?> openPaging(JoinPoint joinPoint) throws Throwable {
		System.out.println("@@@@@@进入切面");
		Integer pageSize = this.defaultPageSize;
		Integer pageNum  = this.defaultPageNum;
		
		ProceedingJoinPoint pJP = (ProceedingJoinPoint)joinPoint;
		Object[] args = pJP.getArgs();
		if(args.length>0) {
			if(args[0] instanceof Map<?,?>) {
				try {
					    Map<?,?> params = (Map)args[0];
					    if(params.containsKey("pageSize")) {
					    	pageSize = (Integer) params.get("pageSize");
					    }
					    if(params.containsKey("pageNum")) {
					    	pageNum = (Integer) params.get("pageNum");
					    }
					
					}
					catch(Exception e) {
						throw new RuntimeException("获取分页参数时出错："+ e.getMessage());
					}
			}
		}
		//开启分页拦截
		//PageHelper只能拦截第一条Mybatis的SQL语句
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		Object obj = pJP.proceed();	//proceed() 得到的是dao返回的list
		page.add(obj);
		return page;
	}
}
