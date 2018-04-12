package com.taobaos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Mall;
import com.taobaos.service.MallServie;
import com.taobaos.serviceImpl.MallServiceImpl;

@WebServlet("/MallDeleteServlet")
public class MallDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MallServie mallServie = new MallServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "京东商城";
		Mall mall = mallServie.updateSelectMallByName(name);
		if (mall == null) {
			response.getWriter().append("Served at: error,暂无此商城").append(request.getContextPath());
		} else {
			Mall mall2=new Mall();
			mall2.setStatus(false);
			mall2.setName(name);
			int result=mallServie.deleteMallStatus(mall2);
			if (result>0) {
				response.getWriter().append("Served at:success").append(request.getContextPath());
			}else {
				response.getWriter().append("Served at:error").append(request.getContextPath());
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
