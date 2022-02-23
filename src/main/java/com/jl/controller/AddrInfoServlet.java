package com.jl.controller;

import com.jl.bean.AddrInfo;
import com.jl.bean.MenberInfo;
import com.jl.biz.AddrInfoBiz;
import com.jl.vo.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class AddrInfoServlet
 */
@RestController
@RequestMapping("/address")
public class AddrInfoServlet {

	@Autowired
    AddrInfoBiz biz;

	@GetMapping("/findAddr")	//获取默认地址
	private JsonModel doFindAddr(HttpServletRequest request, HttpServletResponse response,AddrInfo addr) {
		JsonModel jsonModel=new JsonModel();
		MenberInfo menber=(MenberInfo)request.getSession().getAttribute("menber");
		addr.setMno(menber.getMno());
		try {
			List<AddrInfo> list=biz.getDefaultAddrInfo(addr);
			Map<String,List<AddrInfo>> map=new HashMap<>();
			/*char []chars=list.get(0).getTel().toCharArray();
			StringBuffer tel=new StringBuffer();
			for(int i=0;i<chars.length;i++){
				if(i>=3&&i<7){
					tel.append("*");
				}else {
					tel.append(chars[i]);
				}
				
			}
			list.get(0).setTel(tel.toString());*/
			map.put("addrinfo", list);
			jsonModel.setMsg("successed");
			jsonModel.setCode(1);

			//订单生产返回订单编号
			jsonModel.setObj(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonModel;
	}

	@GetMapping("/getAllAddr")	//获取所有地址
	private JsonModel getAllAddr(HttpServletRequest request, HttpServletResponse response,AddrInfo addr) {
		JsonModel jsonModel=new JsonModel();
		MenberInfo menber=(MenberInfo)request.getSession().getAttribute("menber");
		addr.setMno(menber.getMno());
		try {
			List<AddrInfo> list=biz.getAddrInfo(addr);
			jsonModel.setMsg("successed");
			jsonModel.setCode(1);
			jsonModel.setObj(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonModel;
	}

	@GetMapping("deleteAddr")
	private JsonModel doDeleteAddr(HttpServletRequest request, HttpServletResponse response,AddrInfo addr) {
		JsonModel jsonModel=new JsonModel();
		try {
			int result=biz.deleteAddrInfos(addr);

			jsonModel.setMsg("successed");
			jsonModel.setCode(1);
			jsonModel.setObj(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonModel;
	}

	@GetMapping("insertAddr")
	private JsonModel doInsertAddr(HttpServletRequest request, HttpServletResponse response,AddrInfo addr) {
		JsonModel jsonModel=new JsonModel();
		MenberInfo menber=(MenberInfo)request.getSession().getAttribute("menber");
		addr.setMno(menber.getMno());
		try {
			int result=biz.InsertAddrInfos(addr);
			if (result>0) {
				jsonModel.setMsg("successed");
				jsonModel.setCode(1);
				jsonModel.setObj(result);
			}else {
				jsonModel.setMsg("faild");
				jsonModel.setCode(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonModel;
	}

	@GetMapping("updateAddrinfo")
	private JsonModel doUpdateAddr(HttpServletRequest request, HttpServletResponse response,AddrInfo addr) {
		JsonModel jsonModel=new JsonModel();
		MenberInfo menber=(MenberInfo)request.getSession().getAttribute("menber");
		addr.setMno(menber.getMno());
		try {
			int result=biz.updateAddrInfos(addr);
			if (result>0) {
				jsonModel.setMsg("successed");
				jsonModel.setCode(1);
				jsonModel.setObj(result);
			}else {
				jsonModel.setMsg("faild");
				jsonModel.setCode(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonModel;
	}
	@GetMapping("setDefault")
	private JsonModel setDefaultAddr(HttpServletRequest request, HttpServletResponse response,AddrInfo addr) {
		JsonModel jsonModel=new JsonModel();
		try {
			AddrInfo temp=new AddrInfo();
			MenberInfo menber=(MenberInfo)request.getSession().getAttribute("menber");
			temp.setMno(menber.getMno());
			List<AddrInfo> addrInfoList=biz.getAddrInfo(temp);
			for (AddrInfo info:addrInfoList) {
				if (info.getFlag()!=1){
					continue;
				}
				info.setFlag(0);
				biz.updateAddrInfos(info);
			}
			addr.setFlag(1);
			int result=biz.updateAddrInfos(addr);

			if (result>0) {
				jsonModel.setMsg("successed");
				jsonModel.setCode(1);
				jsonModel.setObj(result);
			}else {
				jsonModel.setMsg("faild");
				jsonModel.setCode(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonModel;
	}
}
