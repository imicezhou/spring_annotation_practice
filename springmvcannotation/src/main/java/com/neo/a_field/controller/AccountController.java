package com.neo.a_field.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.neo.a_field.service.AccountService;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/pageQuery",method=RequestMethod.GET)
	@ResponseBody
	public Object queryAccountWithPaging(Map<String,Object> params) {
		
		Object results = accountService.getAccountsByCriteriaWithPaging(params);
		PageInfo pageInfo = new PageInfo((Page)results);
		return JSONObject.toJSON(pageInfo);
	} 
}
