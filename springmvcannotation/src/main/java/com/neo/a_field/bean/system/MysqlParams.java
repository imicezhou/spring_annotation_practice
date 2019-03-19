package com.neo.a_field.bean.system;

import org.springframework.beans.factory.annotation.Value;

public class MysqlParams {

	public MysqlParams() {
		System.out.println("@@@@ MysqlParams constructor ....");
	}
	
	@Value("${mysql.url}")
	private String url;
	
	@Value("${mysql.driver}")
	private String driverClassWholeName;
	
	@Value("${mysql.username}")
	private String username;
	
	@Value("${mysql.password}")
	private String password;
	
	@Value("${c3p0.acquireIncrement}")
	private Integer acquireIncrement;
	
	@Value("${c3p0.initialPoolSize}")
	private Integer initialPoolSize;
	
	@Value("${c3p0.idleConnectionTestPeriod}")
	private Integer idleConnectionTestPeriod;
	
	@Value("${c3p0.minPoolSize}")
	private Integer minPoolSize;
	
	@Value("${c3p0.maxPoolSize}")
	private Integer maxPoolSize;
	
	@Value("${c3p0.maxStatements}")
	private Integer maxStatements;
	
	@Value("${c3p0.numHelperThreads}")
	private Integer numHelperThreads;
	
	@Value("${c3p0.maxIdleTime}")
	private Integer maxIdleTime;
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriverClassWholeName() {
		return driverClassWholeName;
	}

	public void setDriverClassWholeName(String driverClassWholeName) {
		this.driverClassWholeName = driverClassWholeName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAcquireIncrement() {
		return acquireIncrement;
	}

	public void setAcquireIncrement(Integer acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}

	public Integer getInitialPoolSize() {
		return initialPoolSize;
	}

	public void setInitialPoolSize(Integer initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}

	public Integer getIdleConnectionTestPeriod() {
		return idleConnectionTestPeriod;
	}

	public void setIdleConnectionTestPeriod(Integer idleConnectionTestPeriod) {
		this.idleConnectionTestPeriod = idleConnectionTestPeriod;
	}

	public Integer getMinPoolSize() {
		return minPoolSize;
	}

	public void setMinPoolSize(Integer minPoolSize) {
		this.minPoolSize = minPoolSize;
	}

	public Integer getMaxPoolSize() {
		return maxPoolSize;
	}

	public void setMaxPoolSize(Integer maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public Integer getMaxStatements() {
		return maxStatements;
	}

	public void setMaxStatements(Integer maxStatements) {
		this.maxStatements = maxStatements;
	}

	public Integer getNumHelperThreads() {
		return numHelperThreads;
	}

	public void setNumHelperThreads(Integer numHelperThreads) {
		this.numHelperThreads = numHelperThreads;
	}

	public Integer getMaxIdleTime() {
		return maxIdleTime;
	}

	public void setMaxIdleTime(Integer maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}

	@Override
	public String toString() {
		return "MysqlParams [url=" + url + ", driverClassWholeName=" + driverClassWholeName + ", username=" + username
				+ ", password=" + password + ", acquireIncrement=" + acquireIncrement + ", initialPoolSize="
				+ initialPoolSize + ", idleConnectionTestPeriod=" + idleConnectionTestPeriod + ", minPoolSize="
				+ minPoolSize + ", maxPoolSize=" + maxPoolSize + ", maxStatements=" + maxStatements
				+ ", numHelperThreads=" + numHelperThreads + ", maxIdleTime=" + maxIdleTime + "]";
	}

	public void init() {
		System.out.println("MysqlParams init......");
	}
	
	public void destroy() {
		System.out.println("MysqlParams destroy......");
	}
	
}
