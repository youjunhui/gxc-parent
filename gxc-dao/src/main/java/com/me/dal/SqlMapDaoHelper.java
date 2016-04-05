package com.me.dal;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.me.model.dal.Entity;

/**
 * 基本操作的默认实现
 * 
 * @author chentingjia
 */

@Repository
public class SqlMapDaoHelper<T extends Entity> extends SqlMapClientDaoSupport implements GenricDao<T> {
	
	@Autowired
	private SqlMapClient sqlMapClient;
	
//	@Autowired
//	private AccessListDO accessListDao;

    private String persistentClassShortName;

	public SqlMapDaoHelper(Class<T> persistentClass) {
        this(persistentClass.getSimpleName());
    }

    public SqlMapDaoHelper(String persistentClass) {
        this.persistentClassShortName = persistentClass;
    }

    @Override
    public void deleteById(Long id) {
    	getSqlMapClientTemplate().delete(getQualifiedStatementName("deleteById"), id);
    }

    @SuppressWarnings("unchecked")
	@Override
    public T getById(Long id) {
        return (T) getSqlMapClientTemplate().queryForObject(getQualifiedStatementName("getById"), id);
    }

    @Override
    public T insert(T entity) {
        Date currentDate = new Date();
        entity.setGmtCreated(currentDate);
        entity.setGmtModified(currentDate);
        if(entity.getGmtCreator()==null){
        	entity.setGmtCreator("[SYS]");
        }
        if(entity.getGmtModifier()==null){
        	entity.setGmtModifier("[SYS]");       	
        }
        Object pk = getSqlMapClientTemplate().insert(getQualifiedStatementName("insert"), entity);
        if(pk!=null){
            entity.setId(Long.valueOf(pk.toString()));  	
        }
        return entity;
    }

    @Override
    public void update(T entity) {
        entity.setGmtModified(new Date());
        getSqlMapClientTemplate().update(getQualifiedStatementName("update"), entity);
    }


    protected String getQualifiedStatementName(String statementName) {
        return new StringBuilder(persistentClassShortName).append(".").append(statementName)
                .toString();
    }
}
