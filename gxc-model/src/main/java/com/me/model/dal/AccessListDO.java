package com.me.model.dal;

import java.math.BigDecimal;

public class AccessListDO extends Entity{

    private static final long serialVersionUID = 1L;

    /**
     * 业务员编号
     */
    private String bizSeqno;

    /**
     * 业务流程流水ID
     */
    private BigDecimal bizProcId;

    /**
     * 欺诈甄别类型
     */
    private String accessType;

    /**
     * 欺诈甄别KEY
     */
    private String accessKey;

    /**
     * 欺诈甄别结果
     */
    private String accessResult;

    /**
     * 提示客户信息
     */
    private String promptInfo;

    private String accessRuleType;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getAccessResult() {
        return accessResult;
    }

    public void setAccessResult(String accessResult) {
        this.accessResult = accessResult;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public BigDecimal getBizProcId() {
        return bizProcId;
    }

    public void setBizProcId(BigDecimal bizProcId) {
        this.bizProcId = bizProcId;
    }


    public String getBizSeqno() {
        return bizSeqno;
    }

    public void setBizSeqno(String bizSeqno) {
        this.bizSeqno = bizSeqno;
    }

    public String getPromptInfo() {
        return promptInfo;
    }

    public void setPromptInfo(String promptInfo) {
        this.promptInfo = promptInfo;
    }

    public String toString() {
        return "CcipAccessListDO [accessKey=" + accessKey + ";accessResult=" + accessResult + ";accessType="
                + accessType + ";bizProcId=" + bizProcId + ";bizSeqno=" + bizSeqno + ";promptInfo=" + promptInfo + ";]";
    }

    public String getAccessRuleType() {
        return accessRuleType;
    }

    public void setAccessRuleType(String accessRuleType) {
        this.accessRuleType = accessRuleType;
    }
}
