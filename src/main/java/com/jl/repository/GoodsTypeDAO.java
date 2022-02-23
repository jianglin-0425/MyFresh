package com.jl.repository;

import com.jl.bean.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsTypeDAO {


	public List<GoodsType> findByTrem(GoodsType t) ;

}
