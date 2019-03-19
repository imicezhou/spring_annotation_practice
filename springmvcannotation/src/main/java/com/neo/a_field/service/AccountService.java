package com.neo.a_field.service;

import java.util.List;
import java.util.Map;


public abstract class AccountService implements PagingService {

	
	public List<Object> getAccountsByCriteriaWithPaging(Map<String,Object> criteria) {
		return getPage(criteria);
	}

	
}
