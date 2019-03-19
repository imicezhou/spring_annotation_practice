package com.neo.a_field.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.neo.a_field.bean.business.Account;
import com.neo.a_field.dao.AccountDao;


public abstract class AccountService {

	@Autowired
	AccountDao accountDao;
	/**
	 * \
	 * @return
	 */
	public abstract List<Account> getAccountsByCriteria(Map<String,Object> criteria);
	
	public final Object getAccountsByCriteriaWithPaging(Map<String,Object> criteria) {
		return accountDao.queryAccountByCriteria(criteria);
	}
}
