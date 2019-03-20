package com.neo.a_field.service;

import java.util.List;
import java.util.Map;

import com.neo.a_field.bean.business.Account;


public interface AccountService {

	
	public List<Account> getAccountsByCriteriaWithPaging(Map<String,Object> criteria) ;

	
}
