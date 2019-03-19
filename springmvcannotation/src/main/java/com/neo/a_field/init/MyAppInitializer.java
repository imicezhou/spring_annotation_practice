package com.neo.a_field.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.neo.a_field.config.BeansConfig;
import com.neo.a_field.config.DataSourceConfig;
import com.neo.a_field.config.FastJsonConverterConfig;
import com.neo.a_field.config.RootConfig;
import com.neo.a_field.config.ServletConfig;


public class MyAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class,BeansConfig.class,DataSourceConfig.class,FastJsonConverterConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

	

}
