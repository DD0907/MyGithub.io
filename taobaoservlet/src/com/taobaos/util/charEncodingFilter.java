package com.taobaos.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class charEncodingFilter implements Filter {
	private String encoding;

	public charEncodingFilter() {
		// TODO Auto-generated constructor stub
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//System.out.println(encoding);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		//System.out.println("end filter");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		String e = fConfig.getInitParameter("encoding");
		if (e == null || e.trim().equals("")) {
			encoding = "utf-8";
		} else {
			encoding = e;
		}
	}

}
