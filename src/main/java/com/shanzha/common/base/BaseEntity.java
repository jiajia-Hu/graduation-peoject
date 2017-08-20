package com.shanzha.common.base;

import java.io.Serializable;


import org.springframework.util.StringUtils;

public abstract class BaseEntity<T> implements Serializable {


	private static final long serialVersionUID = -107646110460181302L;
	protected String id;
	protected boolean isNewRecord = false;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isNewRecord() {

		return StringUtils.isEmpty(id);
	}

}
