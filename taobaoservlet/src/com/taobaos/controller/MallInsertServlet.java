package com.taobaos.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.taobaos.pojo.Mall;
import com.taobaos.service.MallServie;
import com.taobaos.serviceImpl.MallServiceImpl;

/**
 * Servlet implementation class MallInsertServlet
 */
@WebServlet("/MallInsertServlet")
public class MallInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MallServie mallServie=new MallServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = "京东商城";
		String note = "京东测试";
		String url = "京东测试";
		String logUrl = "京东测试";
		Boolean status=true;
		Mall mall = mallServie.updateSelectMallByName(name);
		System.out.println(JSON.toJSON(mall));
		if (mall == null) {
			Mall malls=new Mall();
			malls.setName(name);
			malls.setLogUrl(logUrl);
			malls.setUrl(url);
			malls.setNote(note);
			malls.setStatus(status);
			int result = mallServie.insertMall(malls);
			if (result > 0) {
				response.getWriter().append("Served at: success").append(request.getContextPath());
			} else {
				response.getWriter().append("Served at: error").append(request.getContextPath());
			}
		} else {
			response.getWriter().append("Served at: error,商城已存在").append(request.getContextPath());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
