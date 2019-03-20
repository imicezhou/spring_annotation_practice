package com.neo.a_field.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 只扫描@Contorller ,controller只放在servletContext容器中
 * 
 * 如果继承了WebMvcConfigurationSupport，则不需要配置添加@EnableWebMVC
 * 因为@EnableWebMVC引入的类和WebMvcConfigurationSupport都实现自ApplicationContextAware接口
 * 
 * @author Neo
 *
 */
@Configuration
@ComponentScan(
		       value="com.neo.a_field.controller",
		       useDefaultFilters=false,		//禁用spring默认规则，否则自定义filter不生效
			   includeFilters= {
					   				@Filter(type=FilterType.ANNOTATION,classes= {Controller.class})
			                   }
              )
public class ServletConfig extends WebMvcConfigurationSupport{

	/*
	 * 注册fastjson converter组件
	 */
	@Bean
	public HttpMessageConverter<?> fastJsonHttpMessageConverter(){
		
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = 
				new FastJsonHttpMessageConverter();
		
		MediaType jsonType = new MediaType("application", "json", Charset.forName("utf-8"));
		
		List<MediaType> supportedMediaType = new ArrayList<MediaType>();
		supportedMediaType.add(jsonType);
		
		fastJsonHttpMessageConverter.setSupportedMediaTypes(supportedMediaType);
		
		FastJsonConfig jsonConfig = new FastJsonConfig();
		jsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		return fastJsonHttpMessageConverter;
	}
	
	/*
	 * 将fastjson 的转换组件加入到 容器中
	 */
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(fastJsonHttpMessageConverter());
	}
}
