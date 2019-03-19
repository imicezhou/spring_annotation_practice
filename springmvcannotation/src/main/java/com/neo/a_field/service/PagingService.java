package com.neo.a_field.service;

import java.util.List;
import java.util.Map;


/**
 * 提供分页功能
 * @author Neo
 *
 */
public interface PagingService {

	public List<Object> getPage(Map<String,Object> criteria);
}
