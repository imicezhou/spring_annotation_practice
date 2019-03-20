package com.neo.a_field.dao;

import java.util.List;
import java.util.Map;

import com.neo.a_field.bean.business.Account;


public interface AccountDao {

	/*
	 * 一般查询方法
	 * mapper xml中配置此方法即可
	 */
	public List<Account> queryAccountByCriteria(Map<String,Object> criteria);

}
