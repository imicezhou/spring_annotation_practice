package com.neo.a_field.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.a_field.dao.AccountDao;
import com.neo.a_field.service.AccountService;

@Service
public class AccountServiceImpl extends AccountService  {

	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Object> getPage(Map<String, Object> criteria) {
		// TODO Auto-generated method stub
		return accountDao.queryAccountByCriteria(criteria);
	}
	
	
}
