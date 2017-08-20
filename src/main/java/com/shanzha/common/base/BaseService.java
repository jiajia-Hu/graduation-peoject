package com.shanzha.common.base;

import org.springframework.beans.factory.annotation.Autowired;

public  class BaseService<M extends BaseMapper<T>,T> {

	@Autowired
	protected M mapper;

	protected T get(Long id) {
		return mapper.get(id);
	}
	
	public void insert(T t) {
		mapper.insert(t);
	}

}
