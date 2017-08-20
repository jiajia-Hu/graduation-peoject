package com.shanzha.common.base;

import java.util.List;

public interface BaseMapper<T> {

	public T get(Long id);
	
	public List<T> findList(T t);

	public int insert(T t);
	
	public int update(T entity);


}
