package com.jl.biz;


import com.jl.bean.GoodsType;
import com.jl.repository.GoodsTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeBiz {
	@Autowired
	GoodsTypeDAO dao;
	public List<GoodsType> findBytrem(GoodsType t) throws Exception{
		return dao.findByTrem(t);
	}
}
