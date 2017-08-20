package com.shanzha.moduls.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shanzha.moduls.admin.entity.Admin;
import com.shanzha.moduls.admin.entity.AdminExample;
import com.shanzha.moduls.admin.mapper.AdminMapper;

@Service
public class AdminService {

	@Autowired
	AdminMapper adminMapper;

	public int insert(Admin admin) {

		return adminMapper.insert(admin);
	}
	
	public List<Admin> selectByExample(AdminExample example){
		
		
		return adminMapper.selectByExample(example);
	}
	
	public int updateByPrimaryKeySelective(Admin record){
		
		return adminMapper.updateByPrimaryKeySelective(record);
	}
	
	
}
