package com.neo.a_field.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * s只扫描@Contorller 是子容器
 * @author Neo
 *
 */
@Configuration
@ComponentScan(
		       value="com.neo.a_field",
		       useDefaultFilters=false,
			   includeFilters= {
					   				@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
			                   }
              )
public class ServletConfig {

}
