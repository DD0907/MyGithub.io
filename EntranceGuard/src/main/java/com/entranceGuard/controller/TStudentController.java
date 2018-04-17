package com.entranceGuard.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entranceGuard.json.ResultObject;
import com.entranceGuard.pojo.TStudent;
import com.entranceGuard.service.TStudentService;

@Controller
@RequestMapping("/")
public class TStudentController {
	@Autowired
	TStudentService tStudentService;

	@RequestMapping(value = "/tstudent", method = RequestMethod.GET)
	public void main(ModelMap model, HttpServletRequest request) {

	}

	@RequestMapping(value = "/tstudent", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResultObject<String> main(HttpServletRequest request, HttpServletResponse response) {
		String stuId = request.getParameter("name");
		String result = "success";
		String message = "查询成功";
		ResultObject<String> resultObject = new ResultObject<>(result, message);
		List<TStudent> tStudents = null;
		if (stuId.equals("")) {
			tStudents = tStudentService.selectTStudentAll();
		} else {
			tStudents = tStudentService.selectTStudentByStuIds(stuId);
		}
		if (tStudents == null) {
			resultObject.setResult("error");
			resultObject.setMessage("暂无数据");
			resultObject.setMap("tStudent", tStudents);
			resultObject.setData("/EntranceGuard/tStudent.htm");
		} else {
			resultObject.setResult("success");
			resultObject.setMessage("查询成功");
			resultObject.setMap("tStudent", tStudents);
			resultObject.setData("/EntranceGuard/tStudent.htm");
		}
		return resultObject;
	}
}
