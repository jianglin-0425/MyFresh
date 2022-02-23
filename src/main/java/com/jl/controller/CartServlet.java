package com.jl.controller;

import com.jl.bean.CartInfo;
import com.jl.bean.CartVO;
import com.jl.bean.MenberInfo;
import com.jl.biz.CartBiz;
import com.jl.utils.LogUtil;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class CartServlet
 */
@RestController
@RequestMapping("/cart")
public class CartServlet {
	@Autowired
	private CartBiz biz;

    /**
     * 删除购物车中某行数据
     */
	@RequestMapping(value = "delete",method = {RequestMethod.GET,RequestMethod.POST})
	protected JsonModel doDelete(HttpServletRequest req, HttpServletResponse resp,CartInfo t) throws ServletException, IOException {
		JsonModel jsonModel=new JsonModel();
		try {
			int i=biz.delete(t);
			jsonModel.setMsg("successed");
			jsonModel.setCode(i);
		} catch (Exception e) {
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);
			e.printStackTrace();
		} 
		return jsonModel;
    }
	/**
     * 修改购物车中的数量
     * @param request
     * @param response
     */
	@RequestMapping(value = "update",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doUpdate(HttpServletRequest request, HttpServletResponse response,CartInfo t) {
		JsonModel jsonModel=new JsonModel();
		try {
			int i=biz.updateCart(t);
			jsonModel.setMsg("successed");
			jsonModel.setCode(i);
			jsonModel.setObj(t);
		} catch (Exception e) {
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);
			e.printStackTrace();
		} 
		return jsonModel;
	}
	/**
	 * 查看购物车
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "find",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doFind(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jsonModel=new JsonModel();
		HttpSession session=request.getSession();
		MenberInfo menber=(MenberInfo)session.getAttribute("menber");
		try {
			List<CartVO> list=biz.findByMnoVO(menber.getMno());
			jsonModel.setMsg("successed");
			jsonModel.setCode(1);
			jsonModel.setObj(list);
		} catch (Exception e) {
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);
			LogUtil.log.error(e.getMessage());
			e.printStackTrace();
		}
		return jsonModel;
	}
	/**
	 * 添加购物车
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "add",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doAdd(HttpServletRequest request, HttpServletResponse response,CartInfo t,String gno,String num) {
		JsonModel jsonModel=new JsonModel();
		HttpSession session=request.getSession();
		Integer Igno=Integer.parseInt(gno);
		Integer Inum=Integer.parseInt(num);
		MenberInfo menber=(MenberInfo)session.getAttribute("menber");
		try {
			t.setMno(menber.getMno());
			t.setGno(Igno);
			t.setNum(Inum);
			int i=biz.add(t);
			if(i==1){
				try {
					List<CartVO> list=biz.findByMnoVO(menber.getMno());
					session.setAttribute("carts", list);
				} catch (Exception e) {
					LogUtil.log.error(e.getMessage());
					e.printStackTrace();
				}
			}
			jsonModel.setMsg("successed");
			jsonModel.setCode(i);

		} catch (Exception e) {
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);
			LogUtil.log.error(e.getMessage());
			e.printStackTrace();
		}
		return jsonModel;
	}


}
