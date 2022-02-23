package com.jl.repository;

import com.jl.bean.GoodsInfo;
import com.jl.bean.GoodsVO;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;



@Repository
public interface GoodsInfoDao {

	public int add(GoodsInfo t) ;

	public List<GoodsInfo> findByTrem(GoodsInfo t) ;



	public List<GoodsInfo> finds() ;
	
	public int getTotal(GoodsVO t) ;
	/**
	 * 分页查看
	 * @param t
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws Exception 
	 */
	public List<GoodsVO> findByPage(@Param(value = "goodsVO")GoodsVO goodsVO,@Param(value = "pageNum")Integer pageNum,@Param(value = "pageSize")Integer pageSize) ;
	
	/**
	 * 分页的总条数
	 * @param t
	 * @return
	 * @throws SQLException 
	 */
	public int totalPage(GoodsVO t);
	
}
