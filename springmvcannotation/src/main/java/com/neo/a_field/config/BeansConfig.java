 package com.neo.a_field.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.neo.a_field.aspect.PagingAspect;
import com.neo.a_field.bean.system.MysqlParams;

/**
 * 配置普通bean
 * @author Neo
 */
@PropertySource(value={"classpath:configs/mysql.properties"})
@Configuration
public class BeansConfig {

	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Bean(value="mysqlParams",initMethod="init",destroyMethod="destroy")
	public MysqlParams mysqlParams() {
		return new MysqlParams();
	}
	
}
