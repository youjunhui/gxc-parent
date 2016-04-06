package com.me.model.dal;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 数据模型基类
 * @author wangsy
 */
public abstract class Entity implements Serializable {
    private static final long serialVersionUID = 6042639456624076392L;

    /**
     * 主键
     */
    private BigDecimal id;

    /**
     * 创建人
     */
    private String gmtCreator;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改人
     */
    private String gmtModifier;

    /**
     * 修改时间
     */
    private Date gmtModified;

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public String getGmtCreator() {
        return gmtCreator;
    }

    public void setGmtCreator(String gmtCreator) {
        this.gmtCreator = gmtCreator;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getGmtModifier() {
        return gmtModifier;
    }

    public void setGmtModifier(String gmtModifier) {
        this.gmtModifier = gmtModifier;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }
}
