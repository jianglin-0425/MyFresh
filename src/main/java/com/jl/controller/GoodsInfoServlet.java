package com.jl.controller;

import com.jl.bean.GoodsInfo;
import com.jl.bean.GoodsVO;
import com.jl.biz.GoodsInfoBiz;
import com.jl.utils.LogUtil;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class GoodsServlet
 */

@RestController
@RequestMapping("/goods")
public class GoodsInfoServlet {
	@Autowired
	private GoodsInfoBiz biz;


	@GetMapping("findSingle")
	private JsonModel doFindSingle(HttpServletRequest request, HttpServletResponse response, String gno) {
		// TODO Auto-generated method stub
		JsonModel jsonModel=new JsonModel();
		try{
			GoodsInfo list=biz.findSingle(gno);
			Map<String, GoodsInfo> map=new HashMap<String, GoodsInfo>();
			map.put("good", list);
			jsonModel.setMsg("successed");
			jsonModel.setCode(1);

			jsonModel.setObj(map);

		}catch(Exception e){
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);

			LogUtil.log.error(e.getMessage());
			e.printStackTrace();
		}
		return jsonModel;
	}
	@RequestMapping(value = "finds",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doFinds(HttpServletRequest request, HttpServletResponse response) {
		JsonModel jsonModel=new JsonModel();
		try {
			Map<String, Object> map=biz.finds();

			jsonModel.setMsg("successed");
			jsonModel.setCode(1);
			jsonModel.setObj(map);
		} catch (Exception e) {
			// TODO: handle exception
			jsonModel.setMsg("faild");
			jsonModel.setCode(0);

			LogUtil.log.error(e.getMessage());
			e.printStackTrace();
		}
		return jsonModel;
	}
	@RequestMapping(value = "page",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doPage(HttpServletRequest request, HttpServletResponse response,GoodsVO bean,String page,String rows) {
		JsonModel jsonModel=new JsonModel();

		try {
			Map<String, Object> map=biz.findByPage(bean,Integer.parseInt(page), Integer.parseInt(rows));
			System.out.println(map.toString());

			jsonModel.setMsg("successed");
			jsonModel.setCode(1);

			jsonModel.setObj(map);
		} catch (Exception e) {

			jsonModel.setMsg("faild");
			jsonModel.setCode(0);
		}
		return jsonModel;
	}

	@RequestMapping(value = "findPage",method = {RequestMethod.GET,RequestMethod.POST})
	private JsonModel doFindPage(HttpServletRequest request, HttpServletResponse response,GoodsVO v,String page,String rows) {
		JsonModel jsonModel=new JsonModel();
		try {

			Map<String, Object> map=biz.findByPage(v, Integer.parseInt(page), Integer.parseInt(rows));
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
}
