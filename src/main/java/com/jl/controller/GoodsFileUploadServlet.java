package com.jl.controller;

import com.jl.bean.GoodsInfo;
import com.jl.biz.GoodsInfoBiz;
import com.jl.utils.FileUploadUtil;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class GoodsFileUploadServlet{

	@Autowired
	GoodsInfoBiz biz;


	@RequestMapping(value = "GoodsFileUpload",produces = "text/html;charset=utf-8",method = {RequestMethod.GET,RequestMethod.POST})
	protected JsonModel doPost(HttpServletRequest request, HttpServletResponse response, GoodsInfo bean, @RequestParam MultipartFile fpics) throws ServletException, IOException {
		JsonModel jsonModel =new JsonModel();
		try {
			System.out.println(fpics.getSize());
			String s= FileUploadUtil.paraseRequest(fpics);
			bean.setPics(s);
			if (bean.getPics()!=null){
				int i=biz.add(bean);
				jsonModel.setCode(i);
				jsonModel.setMsg("successed");
			}
			System.out.println(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonModel;
	}

}
