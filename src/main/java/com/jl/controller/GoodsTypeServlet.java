package com.jl.controller;

import com.jl.bean.GoodsType;
import com.jl.biz.GoodsTypeBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;



@RestController
@RequestMapping("/goodsType")
public class GoodsTypeServlet {

	@Autowired
	GoodsTypeBiz biz;

	@RequestMapping(value = "findGoodsType",method = {RequestMethod.GET,RequestMethod.POST})
	protected List<GoodsType> doFind(HttpServletRequest request,HttpServletResponse response,GoodsType bean){
		List<GoodsType> list=null;
		try {
			list=biz.findBytrem(bean);

		} catch (Exception e) {
		}
		return list;
	}

}
