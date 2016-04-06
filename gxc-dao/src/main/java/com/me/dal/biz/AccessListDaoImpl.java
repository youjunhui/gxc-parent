package com.me.dal.biz;

import org.springframework.stereotype.Repository;

import com.me.dal.SqlMapDaoHelper;
import com.me.model.dal.AccessListDO;

@Repository
public class AccessListDaoImpl extends SqlMapDaoHelper<AccessListDO> implements AccessListDao {
	
	public AccessListDaoImpl() {
		super(AccessListDO.class);
	}
	
}
