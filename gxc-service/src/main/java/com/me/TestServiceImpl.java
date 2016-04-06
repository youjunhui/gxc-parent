package com.me;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.me.dal.biz.AccessListDao;
import com.me.model.dal.AccessListDO;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private AccessListDao accessListDao;

	@Override
	public <T> T getById() {
		AccessListDO accessListDO = new AccessListDO();
		accessListDO.setId(BigDecimal.valueOf(100L));;
		// TODO Auto-generated method stub
		return (T) accessListDao.getByKey(accessListDO);
	}

}
