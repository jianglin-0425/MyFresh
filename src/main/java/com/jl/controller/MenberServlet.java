package com.jl.controller;

import com.jl.bean.CartVO;
import com.jl.bean.MenberInfo;
import com.jl.bean.OrderInfo;
import com.jl.biz.CartBiz;
import com.jl.biz.MenberBiz;
import com.jl.biz.OrderBiz;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class MenberServlet
 */

@RestController
@RequestMapping("/menber")
public class MenberServlet {
	@Autowired
	private MenberBiz biz;
	@Autowired
	private CartBiz cartBiz;

	@Autowired
	OrderBiz orderBiz;

	@RequestMapping(value = "loginOut",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel loginOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonModel jsonModel=new JsonModel();
		HttpSession session=request.getSession();
		session.removeAttribute("menber");
		jsonModel.setMsg("successed");
		jsonModel.setCode(1);
		return jsonModel;
	}

	@RequestMapping(value = "check",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		JsonModel jsonModel=new JsonModel();
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		MenberInfo menber=(MenberInfo)session.getAttribute("menber");
		Map<String, Object> map=new HashMap<String, Object>();
		if(menber==null){
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);
			return jsonModel;
		}
		try {
			List<CartVO> carts =cartBiz.findByMnoVO(menber.getMno());
			map.put("menber", menber);
			map.put("carts", carts);

			jsonModel.setMsg("successed");
			jsonModel.setCode(1);


			jsonModel.setObj(map);
		} catch (Exception e) {
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);

			e.printStackTrace();
		}
		return jsonModel;
	}
	@RequestMapping( value = "login",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doLogin(HttpServletRequest request, HttpServletResponse response,MenberInfo bean) {
		JsonModel jsonModel=new JsonModel();
		// TODO Auto-generated method stub
		try {
			MenberInfo menber=biz.login(bean);
			if (menber==null){
				jsonModel.setMsg("faild");
				jsonModel.setCode(0);
				return jsonModel;
			}
			OrderInfo o=new OrderInfo();
			orderBiz.getOrder(o);
			o.setMno(menber.getMno());
			List<OrderInfo> orderInfos=orderBiz.getOrder(o);
			System.out.println(orderInfos);
			HttpSession session=request.getSession();
			if (null==menber) {
				jsonModel.setMsg("faild");
				jsonModel.setCode(0);

			}else{
				//会员登录成功
				List<CartVO> list=cartBiz.findByMnoVO(menber.getMno());
				session.setAttribute("carts", list);
				session.setAttribute("menber", menber);
				session.setAttribute("orders", orderInfos);
				jsonModel.setMsg("successed");
				jsonModel.setCode(1);

				//订单生产返回订单编号
				jsonModel.setObj(menber);
			}
		}catch (Exception e) {
			// TODO: handle exception
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);

			e.printStackTrace();
		}
		return jsonModel;
	}


	@RequestMapping(value = "page",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doPage(HttpServletRequest request, HttpServletResponse response,MenberInfo bean) {
		JsonModel jsonModel=new JsonModel();
		// TODO Auto-generated method stub
		//获取每个显示的条数以及页码数
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		try {
			System.out.println(bean.toString());
			Map<String, Object> map=biz.findByPage(bean,Integer.parseInt(rows), Integer.parseInt(page));

			jsonModel.setMsg("successed");
			jsonModel.setCode(1);

			//订单生产返回订单编号
			jsonModel.setObj(map);
		} catch (Exception e) {
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);

			//订单生产返回订单编号
			// TODO: handle exception
		}
		return jsonModel;
	}

	@RequestMapping(value = "find",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doFind(HttpServletRequest request, HttpServletResponse response,MenberInfo bean) {
		JsonModel jsonModel=new JsonModel();
		// TODO Auto-generated method stub
		try {
			List<MenberInfo> list=biz.findByTrem(bean);

			jsonModel.setMsg("successed");
			jsonModel.setCode(1);

			jsonModel.setObj(list);
		} catch (Exception e) {
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);

			// TODO: handle exception
			e.printStackTrace();
		}
		return jsonModel;
	}
}
