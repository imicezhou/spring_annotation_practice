package com.neo.a_field.config;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInterceptor;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.neo.a_field.bean.system.MysqlParams;

/**
 * 数据源配置
 * @author Neo
 * 
 */
@Configuration
@MapperScan(basePackages= {"com.neo.a_field.dao"})
@EnableTransactionManagement
public class DataSourceConfig {

	private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);
	
	/**
	 *   
	 * @param mysqlParams
	 * @return
	 */
	@Bean
	@DependsOn(value="mysqlParams")
	public DataSource mysqlDataSource(MysqlParams mysqlParams) {
		ComboPooledDataSource combDs = null;
		try {
			//
			combDs = new ComboPooledDataSource();
			combDs.setDriverClass(mysqlParams.getDriverClassWholeName());
			combDs.setJdbcUrl(mysqlParams.getUrl());
			combDs.setUser(mysqlParams.getUsername());
			combDs.setPassword(mysqlParams.getPassword());
			
			//
			combDs.setAcquireIncrement(mysqlParams.getAcquireIncrement());
			combDs.setInitialPoolSize(mysqlParams.getInitialPoolSize());
			combDs.setIdleConnectionTestPeriod(mysqlParams.getIdleConnectionTestPeriod());
			combDs.setMinPoolSize(mysqlParams.getMinPoolSize());
			combDs.setMaxPoolSize(mysqlParams.getMaxPoolSize());
			combDs.setMaxStatements(mysqlParams.getMaxStatements());
			combDs.setNumHelperThreads(mysqlParams.getNumHelperThreads());
			combDs.setMaxIdleTime(mysqlParams.getMaxIdleTime());
			
		} catch (PropertyVetoException e) {
			logger.debug("<<<<<数据库连接失败"+e.getMessage());
		}
		
		return combDs;
	}
	
	
	/**
	 * mybatis sqlsessionFactory
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory(@Autowired DataSource dataSource) {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		
		PathMatchingResourcePatternResolver resourceResol = new PathMatchingResourcePatternResolver();
		Resource[] resources = null;
		try {
			resources = resourceResol.getResources("classpath*:com/neo/a_field/dao/impl/*.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sqlSessionFactory.setMapperLocations(resources);
		return sqlSessionFactory;
	}
	
	/**
	 *  事务管理器
	 */
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	
	
	/**
	 * 分页插件
	 */
	@Bean
	public PageHelper pageHelper() {
		PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //在sqlSessionFactory中加入pagehelper的拦截器，否则插件不能起作用
        new SqlSessionFactoryBean().setPlugins(new Interceptor[] {new PageInterceptor()});
        
        return pageHelper;
	}
}
