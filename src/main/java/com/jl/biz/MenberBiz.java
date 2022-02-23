package com.jl.biz;


import com.jl.bean.MenberInfo;
import com.jl.repository.MenberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenberBiz {

	@Autowired
	MenberDao dao;


	public MenberInfo login(MenberInfo t) throws Exception {
		t.setStatus(1);//1可用  2禁用
		List<MenberInfo> list=dao.findByTrem(t);
		if (null!=list && list.size()>0) {
			return list.get(0);
		}
		return null;
 	}
	//查询member
	public List<MenberInfo> findByTrem(MenberInfo bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.findByTrem(bean);
	}
	public Map<String, Object> findByPage(MenberInfo admin,Integer pageSize,Integer pageNum) throws Exception {
		// TODO Auto-generated method stub
		List<MenberInfo> list=dao.findByPage(admin, pageSize, pageNum);
		int total=dao.getTotal(admin);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
}
