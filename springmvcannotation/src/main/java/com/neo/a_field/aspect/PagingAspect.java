package com.neo.a_field.aspect;

import java.util.List;
import java.util.Map;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


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
	@Pointcut(value="execution(* com.neo.a_field.service..*(..))")
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
				try 
				{
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
		PageHelper.startPage(pageNum, pageSize);
		
		//在使用了pagehelper插件后，原方法返回的实际是Page类型 ,(Page extends List)
		Object obj = pJP.proceed();	
		return (Page)obj;
	}
}
