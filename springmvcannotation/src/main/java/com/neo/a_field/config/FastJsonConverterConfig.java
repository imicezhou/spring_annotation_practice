package com.neo.a_field.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 如果继承了WebMvcConfigurationSupport，则不需要配置添加@EnableWebMVC
 * 因为@EnableWebMVC的作用就是往容器中注册这个类
 * @author Neo
 *
 */
@Configuration
public class FastJsonConverterConfig extends WebMvcConfigurationSupport {

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
	
	/**
	 *  s将fastjson的converter加入到messageConverter容器中，必不可少
	 *  s否则，若没有配置spring支持的jackson，那么返回就会出错，无法找到
	 *  s处理json需要的converter
	 */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(fastJsonHttpMessageConverter());
	}
}
