package com.jl.controller;

import com.jl.bean.AdminInfo;
import com.jl.biz.AdminBiz;
import com.jl.utils.LogUtil;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class AdminServlet
 */
@RestController
@RequestMapping("/admin")
public class AdminServlet {
	@Autowired
	AdminBiz biz;


	@GetMapping("/page")
	private JsonModel doPage(HttpServletRequest request, HttpServletResponse response,AdminInfo bean) {
		JsonModel jsonModel=new JsonModel();
		// TODO Auto-generated method stub
		//获取每个显示的条数以及页码数
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		try {
			Map<String, Object> map=biz.findByPage(bean,Integer.parseInt(rows), Integer.parseInt(page));

			jsonModel.setMsg("successed");
			jsonModel.setCode(1);

			//订单生产返回订单编号
			jsonModel.setObj(map);
		} catch (Exception e) {
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");
			// TODO: handle exception
		}
		return jsonModel;
	}

	@GetMapping("/find")
	private JsonModel doFind(HttpServletRequest request, HttpServletResponse response,AdminInfo bean) {
		JsonModel jsonModel=new JsonModel();
		// TODO Auto-generated method stub
		try {

			List<AdminInfo> list=biz.findByTrem(bean);
			jsonModel.setMsg("successed");
			jsonModel.setCode(1);

			//订单生产返回订单编号
			jsonModel.setObj(list);
		} catch (Exception e) {
			// TODO: handle exception
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");
			e.printStackTrace();
		}
		return jsonModel;
	}

	/**
	 * 管理员登录
	 * @param request
	 * @param response
	 */
	@PostMapping("login")
	private JsonModel doLogin(HttpServletRequest request, HttpServletResponse response,AdminInfo bean) {
		JsonModel jsonModel=new JsonModel();
		// TODO Auto-generated method stub
		try {
			AdminInfo admin=biz.login(bean);
			if (null==admin) {
				jsonModel.setMsg("faild");
				jsonModel.setCode(0);
			}else {
				request.getSession().setAttribute("admin", admin);
				jsonModel.setMsg("successed");
				jsonModel.setCode(1);

				//订单生产返回订单编号
				jsonModel.setObj(admin);
			}
		} catch (Exception e) {
			// TODO: handle exception
			jsonModel.setCode(0);
			jsonModel.setMsg("faild");
			LogUtil.log.error(e.getMessage());
			e.printStackTrace();
		}
		return jsonModel;
	}


}
