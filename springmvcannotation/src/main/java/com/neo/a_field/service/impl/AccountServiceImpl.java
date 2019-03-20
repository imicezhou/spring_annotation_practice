package com.neo.a_field.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.a_field.bean.business.Account;
import com.neo.a_field.dao.AccountDao;
import com.neo.a_field.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Override
	public List<Account> getAccountsByCriteriaWithPaging(Map<String, Object> criteria) {
		List<Account> accounts = accountDao.queryAccountByCriteria(criteria);
		return accounts;
	}
	
}
