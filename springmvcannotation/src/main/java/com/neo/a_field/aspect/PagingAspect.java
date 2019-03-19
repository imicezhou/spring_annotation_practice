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
 * open开启分页的切面
 * @author Neo
 *
 */
@Aspect
public class PagingAspect {

	private final Integer defaultPageSize = 3;
	
	private final Integer defaultPageNum  = 1;
	
	@Pointcut(value="execution(public * *withPaging(..))")
	public void pointCut() {};
	
	@Around("pointCut()")
	public Page<?> openPaging(JoinPoint joinPoint) throws Throwable {
		
		Integer pageSize = this.defaultPageSize;
		Integer pageNum  = this.defaultPageNum;
		
		ProceedingJoinPoint pJP = (ProceedingJoinPoint)joinPoint;
		Object[] args = pJP.getArgs();
		if(args.length>0) {
			if(args[0] instanceof Map<?,?>) {
				Map<?,?> params = (Map)args[0];
				try {
					if(params.containsKey("pageSize")) {
						pageSize = (Integer) params.get("pageSize");
					}
					if(params.containsKey("pageNum")) {
						pageNum = (Integer) params.get("pageNum");
					}
					
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		Page<Object> page = PageHelper.startPage(pageNum, pageSize);
		Object obj = pJP.proceed();	//proceed返回的是list
		page.add(obj);
		return page;
	}
}
