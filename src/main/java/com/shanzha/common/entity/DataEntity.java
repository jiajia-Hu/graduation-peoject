package com.shanzha.common.entity;

import java.util.Date;

import com.shanzha.common.base.BaseEntity;

public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;
	protected String createBy; // 创建者
	protected Date createDate; // 创建日期
	protected String updateBy; // 更新者
	protected Date updateDate; // 更新日期
	protected int delFlag; // 删除标记（0：正常；1：删除；2：审核）

}
