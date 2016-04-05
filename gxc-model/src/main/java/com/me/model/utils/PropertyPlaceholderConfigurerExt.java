/*
 * 文 件 名  :  PropertyPlaceholderConfigurerExt.java
 * 版    权    :  
 * 描    述    :  <描述>
 * 创建人    :  
 * 创建时间:  下午3:05:31
 */
package com.me.model.utils;

import java.util.HashMap;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.me.model.enums.common.CommonEnum;

/**
 * 资源文件加密字段处理工具类
 * 
 * @author 
 * @version [版本号, 2013-7-1]
 */
public class PropertyPlaceholderConfigurerExt extends PropertyPlaceholderConfigurer {
    
    private static HashMap<String, String> ctxPropertiesMap;

	@Override
	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		// TODO Auto-generated method stub
		super.processProperties(beanFactoryToProcess, props);
		ctxPropertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	/**
     * 需要加密的字段，用于标识那些字段是加过密的
     */
    private String[] encryptPropNames = { /*"jdbc.password"*/};
    
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = CryptoUtil.aesDecrypt(propertyValue, CommonEnum.加密属性文件的密钥.code());
            return decryptValue;
        }
        else {
            return propertyValue;
        }
    }
    
    /**
     * 判断属性是否为加密的属性
     * 
     * @author 
     * @param propertyName
     * @return [参数说明]
     * @return boolean [返回类型说明]
     */
    private boolean isEncryptProp(String propertyName) {
        for (int i = 0; i < encryptPropNames.length; i++) {
            if (encryptPropNames[i].equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 获取属性
     * @param name
     * @return
     */
    public static String getContextProperty(String name) { 
        return ctxPropertiesMap.get(name); 
    } 
}
