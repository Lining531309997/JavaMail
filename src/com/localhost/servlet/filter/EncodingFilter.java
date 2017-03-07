package com.localhost.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	// 存储编码格式信息
	private String encodingName = null;
	
    /**
     * Default constructor. 
     */
    public EncodingFilter() {}
    
    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
    	// 获取web.xml文件中编码格式信息
    	encodingName = fConfig.getInitParameter("encoding");
    }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 如果web.xml文件中设置了编码格式，则使用该编码格式；
		if (encodingName != null) {
			request.setCharacterEncoding(encodingName);
			response.setCharacterEncoding(encodingName);
		} else {
			// 如果web.xml文件没有设置编码格式，默认使用UTF-8
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
		}
		
		chain.doFilter(request, response);
	}
	
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
