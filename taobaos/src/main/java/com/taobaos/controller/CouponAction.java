package com.taobaos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taobaos.json.ResultObject;
import com.taobaos.pojo.Coupon;
import com.taobaos.service.CouponService;

@Controller
@RequestMapping("/")
public class CouponAction {
	@Autowired
	CouponService couponService;

	@RequestMapping(value = "/coupon", method = RequestMethod.GET)
	public void coupon(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/coupon", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> coupon(HttpServletResponse response, HttpServletRequest request) {
		String name = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<String>(result, message);
		List<Coupon> coupon = null;
		if (name.equals("")) {
			coupon = couponService.selectCouponAll();
		} else {
			coupon = couponService.selectCouponByName(name);
		}
		if (coupon == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("coupon", coupon);
			resultObject.setData("/taobaos/coupon.htm");
		} else {
			resultObject.setMap("coupon", coupon);
			resultObject.setData("/taobaos/coupon.htm");
		}
		return resultObject;
	}
}
