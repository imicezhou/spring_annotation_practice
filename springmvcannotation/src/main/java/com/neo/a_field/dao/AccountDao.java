package com.neo.a_field.dao;

import java.util.List;
import java.util.Map;

import com.neo.a_field.bean.business.Account;

public interface AccountDao {

	public List<Account> queryAccountByCriteria(Map<String,Object> criteria);

}
