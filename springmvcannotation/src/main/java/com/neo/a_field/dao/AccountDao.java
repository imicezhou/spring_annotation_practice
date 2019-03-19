package com.neo.a_field.dao;

import java.util.List;
import java.util.Map;


public interface AccountDao {

	/*
	 * 一般查询方法
	 * mapper xml中配置此方法即可
	 */
	public List<Object> queryAccountByCriteria(Map<String,Object> criteria);

}
