package com.me.dal;

import com.me.model.dal.Entity;

/**
 * DAO基类
 *
 * @author tingjia.chentj
 */
public interface GenricDao<T extends Entity> {

    /**
     * 新增记录
     * 
     * @param entity
     * @return 
     */
    T insert(T entity);

    /**
     * 根据唯一标识删除记录
     * 
     * @param id 
     */
    void deleteById(Long id);

    /**
     * 修改记录
     * 
     * @param entity 
     */
    void update(T entity);
    
    /**
     * 根据唯一标识获取记录
     * 
     * @param id
     * @return 
     */
    T getById(Long id);
}
