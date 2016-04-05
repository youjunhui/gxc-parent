/*
 * 文 件 名  :  SecurityInterceptor.java
 * 版    权    :  
 * 描    述    :  <描述>
 * 创建人    :  
 * 创建时间:  下午3:47:38
 */
package com.me.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.me.model.enums.web.WebCommonEnum;


/**
 * 权限拦截器
 * 
 * @author 
 * @version [版本号, 2013-7-1]
 */
public class SecurityInterceptor implements HandlerInterceptor {
    
    // 不需要拦截的资源
    private List<String> excludeUrls;
    
    /**
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());
        // 如果要访问的资源是不需要验证的
        if (excludeUrls.contains(url)) {
            return true;
        }
        request.getSession().setAttribute(WebCommonEnum.Session中的User.code(), Long.valueOf(-1));
        return true;
    }
    
    /**
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }
    
    /**
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
    
    public List<String> getExcludeUrls() {
        return excludeUrls;
    }
    
    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }
}
