package com.taobaos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taobaos.pojo.Coupon;
import com.taobaos.service.CouponService;
import com.taobaos.serviceImpl.CouponServiceImpl;

@WebServlet("/CouponSelectAllServlet")
public class CouponSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CouponService couponService = new CouponServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		if (name.equals("") || name.equals(null)) {
			List<Coupon> coupons = couponService.selectCouponAll();
			if (coupons == null) {
				response.getWriter().append("Served at: 暂无优惠券").append(request.getContextPath());
			} else {
				request.setAttribute("coupon", coupons);
				request.getRequestDispatcher("/page/coupon.jsp").forward(request, response);
			}
		} else {
			List<Coupon> coupons = couponService.selectCouponByName(name);
			if (coupons == null) {
				response.getWriter().append("Served at: 暂无优惠券").append(request.getContextPath());
			} else {
				request.setAttribute("coupon", coupons);
				request.getRequestDispatcher("/page/coupon.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
