package com.neo.a_field.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

import com.neo.a_field.aspect.PagingAspect;


/**
 * b不扫描Controller，是父容器
 * @author Neo
 *
 */
@Configuration
@EnableAspectJAutoProxy	//开启AOP
@ComponentScan(
				value= "com.neo.a_field",
				excludeFilters= {
									@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
								}
			  )
public class RootConfig {

	@Bean 
	public PagingAspect pagingAspect() { 
		return new PagingAspect(); 
	}
}
