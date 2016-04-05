package com.me;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.dal.biz.AccessListDao;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private AccessListDao accessListDao;

	@Override
	public <T> T getById() {
		// TODO Auto-generated method stub
		return (T) accessListDao.getById(1l);
	}

}
