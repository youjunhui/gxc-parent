package com.me.dal.biz;

import com.me.dal.GenricDao;
import com.me.model.dal.AccessListDO;

public interface AccessListDao extends GenricDao<AccessListDO>{
	
	public void deleteById(long id);

}
