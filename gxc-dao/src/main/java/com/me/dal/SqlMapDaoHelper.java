package com.me.dal;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.me.model.dal.Entity;

/**
 * 基本操作的默认实现
 * 
 * @author chentingjia
 */
@SuppressWarnings("deprecation")
public class SqlMapDaoHelper<T extends Entity> extends SqlMapClientDaoSupport implements GenricDao<T> {
	
    private String persistentClassShortName;

	public SqlMapDaoHelper(Class<T> persistentClass) {
        this(persistentClass.getSimpleName());
    }

    public SqlMapDaoHelper(String persistentClass) {
        this.persistentClassShortName = persistentClass;
    }

	@Override
    public void deleteByKey(T entity) {
    	getSqlMapClientTemplate().delete(getQualifiedStatementName("deleteByKey"), entity);
    }

    @SuppressWarnings({ "unchecked" })
	@Override
    public T getByKey(T entity) {
        return (T) getSqlMapClientTemplate().queryForObject(getQualifiedStatementName("getByKey"), entity);
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
            entity.setId(BigDecimal.valueOf(Long.valueOf(pk.toString())));  	
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
