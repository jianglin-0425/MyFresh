package com.jl.controller;


import com.jl.bean.*;
import com.jl.biz.CartBiz;
import com.jl.biz.GoodsInfoBiz;
import com.jl.biz.OrderBiz;
import com.jl.biz.OrderItemBiz;
import com.jl.utils.StringUtil;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class OrderServlet
 */
@RestController
@RequestMapping("order")
public class OrderServlet {

	@Autowired
    OrderBiz biz;
    @Autowired
	CartBiz cartBiz;
	@Autowired
    OrderItemBiz itemBiz;
	@Autowired
	GoodsInfoBiz goodBiz;


   

	@RequestMapping(value = "/updateOrder",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doUpdate(HttpServletRequest request, HttpServletResponse response,OrderInfo orderInfo) throws UnsupportedEncodingException {
		JsonModel jsonModel=new JsonModel();
		String no=(String) request.getSession().getAttribute("orderno");
		orderInfo.setOno(no);
		System.out.println(orderInfo);
		System.out.println();
		orderInfo.setStatus(1);
		try {
			int i=biz.updateOrder(orderInfo);
			jsonModel.setMsg("successed");
			jsonModel.setCode(1);
			jsonModel.setObj(i);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonModel;
	}

	@RequestMapping(value = "/findOrder",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doFind(HttpServletRequest request, HttpServletResponse response,String ono) {
		JsonModel jsonModel=new JsonModel();
		OrderItemInfo o=new OrderItemInfo();
		HttpSession session=(HttpSession)request.getSession();
		List<OrderInfo> orderInfo=(List<OrderInfo>)session.getAttribute("orders");
		if (ono==null||"".equals(ono)) {
			o.setOno(orderInfo.get(0).getOno());
		}else{
			o.setOno(ono);
		}
		//List<OrderInfo> list=biz.getOrder(o);
		List<OrderItemInfo> list=itemBiz.getOrderItem(o);//有多个goods
		List<GoodsInfo> goods=new ArrayList<>();
		GoodsInfo g=null;
		for (OrderItemInfo item : list) {
			g=new GoodsInfo();
			g.setGno(item.getGno());
			goods.add(g);
		}

		List<GoodsInfo> goodsInfos=goodBiz.findMulit(goods);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("orderGoods",goodsInfos);
		map.put("orderitem",list);
		jsonModel.setMsg("successed");
		jsonModel.setCode(1);
		jsonModel.setObj(map);
		return jsonModel;
	}

	@RequestMapping(value = "/genOrder",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doGenOrder(HttpServletRequest request, HttpServletResponse response,String cnos,String cnums) {
		JsonModel jsonModel=new JsonModel();
		HttpSession session=request.getSession();
		MenberInfo menber=(MenberInfo)session.getAttribute("menber");

		String orderid= StringUtil.genOid(menber.getMno());
		OrderInfo o=new OrderInfo();
		o.setOno(orderid);
		o.setMno(menber.getMno());
		try {
			int i=biz.genOrder(o, cnos, cnums);
			System.out.println(i);
			if (i>0) {
				//重新更新购物车中的数据
				List<CartInfo> list=cartBiz.findByMno(menber.getMno());
				session.setAttribute("carts", list);
				jsonModel.setMsg("successed");
				jsonModel.setCode(1);

				//订单生产返回订单编号
				jsonModel.setObj(orderid);
			}else {
				jsonModel.setMsg("fail");
				jsonModel.setCode(0);

			}
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		return jsonModel;
	}
	//获取全部订单
	@RequestMapping(value = "/findAllOrder",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel findAllOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		JsonModel jsonModel=new JsonModel();
		OrderItemInfo o=new OrderItemInfo();
		HttpSession session=(HttpSession)request.getSession();

		MenberInfo menber=(MenberInfo)session.getAttribute("menber");
		if (menber==null){
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);
			return jsonModel;
		}
		OrderInfo order=new OrderInfo();
		order.setMno(menber.getMno());
		List<OrderInfo> orderInfo=biz.getOrder(order);
		List<Map<String, Object>> result=new ArrayList<>();
		Map<String, Object> map=null;
		for (OrderInfo info: orderInfo) {
			map=new HashMap<String, Object>();
			o.setOno(info.getOno());
			List<OrderItemVO> list=itemBiz.getItemVO(o);//有多个goods
			map.put("orderInfo",info);
			map.put("orderitem",list);
			System.out.println(list);
			result.add(map);
		}

		//List<OrderInfo> list=biz.getOrder(o);
		jsonModel.setMsg("successed");
		jsonModel.setCode(1);
		jsonModel.setObj(result);
		return jsonModel;
	}
}
