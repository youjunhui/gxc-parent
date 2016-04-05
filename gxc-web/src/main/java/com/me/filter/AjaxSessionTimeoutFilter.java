package com.me.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.me.model.enums.web.WebCommonEnum;

public class AjaxSessionTimeoutFilter implements Filter {

	private Logger logger = Logger.getLogger(AjaxSessionTimeoutFilter.class);
	private Set<String> safeUrls;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.safeUrls = new HashSet<String>();
		String url = getPropertyFromInitParams(filterConfig, "safeUrls", null);
		if (url != null) {
			String[] urls = url.split("\n");
			for (String s : urls) {
				s = s.trim();
				if (!"".equals(s)) {
					this.safeUrls.add(s);
				}
			}
		}
	}

	/**
	 * 只针对ajax进行处理
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 系统来源 1:云发网 0:公众云平台 不传默认为1
		if (null != req.getParameter("scode")) {
			req.getSession().setAttribute("scode", req.getParameter("scode"));
		}
		// 判断session里是否有用户信息
		if (req.getSession().getAttribute(WebCommonEnum.Session中的User.code()) == null) {
			// 如果是ajax请求响应头会有，x-requested-with；
			// 如果是安全地址不进行处理　
			if (req.getHeader("x-requested-with") != null && req.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest") && !this.isSafeUrl(req)) {
				logger.warn("ajax session timeout!");
				res.setStatus(911);// 表示session timeout
			} else {
				chain.doFilter(req, res);
			}
		} else {
			chain.doFilter(req, res);
		}

	}

	@Override
	public void destroy() {

	}

	/**
	 * 获取filter init param <一句话功能简述> <功能详细描述>
	 * 
	 * @param filterConfig
	 * @param propertyName
	 *            　参数名称　
	 * @param defaultValue
	 *            如果从参数中没有取到，则默认返回的值
	 * @return [参数说明]
	 * @return String
	 * @exception throws [违例类型] [违例说明]
	 */
	private final String getPropertyFromInitParams(FilterConfig filterConfig, String propertyName, String defaultValue) {
		String value = filterConfig.getInitParameter(propertyName);
		if (StringUtils.isNotBlank(value)) {
			return value;
		}
		return defaultValue;
	}

	/**
	 * 判断是否要跳过的地址 <一句话功能简述> <功能详细描述>
	 * 
	 * @param request
	 * @return [参数说明]
	 * @return boolean
	 * @exception throws [违例类型] [违例说明]
	 */
	private boolean isSafeUrl(HttpServletRequest request) {
		String url = request.getServletPath();
		for (String safeUrl : safeUrls) {
			if (url.startsWith(safeUrl)) {
				// 当前被请求的地址　包含filter里配置的安全地址,说明该地址是安全的
				return true;
			}
		}
		return false;
	}
}
