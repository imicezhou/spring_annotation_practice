package com.neo.a_field.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.neo.a_field.service.AccountService;

@Controller
@RequestMapping(value="/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/pageQuery",method=RequestMethod.GET)
	@ResponseBody
	public Object queryAccountWithPaging() {
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		Object results = accountService.getAccountsByCriteriaWithPaging(params);
		System.out.print("results is instanceof page ???? : ");
		System.out.println(results.getClass().getName());
		return JSONObject.toJSON(results);
	} 
}
