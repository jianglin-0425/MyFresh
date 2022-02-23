package com.jl.repository;

import com.jl.bean.CartInfo;
import com.jl.bean.CartVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDAO {

	public int add(CartInfo t);

	public List<CartInfo> findByTrem(CartInfo t) ;


	public int update(CartInfo t) ;


	public int delete(CartInfo t) ;

	public int deleteByCnos(String[] cnos);
	/**
	 * 查看购物车中的信息
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public List<CartVO> findVoByTrem(CartVO t) ;

	public List<CartVO> findByCnos(@Param(value = "cnos") String[] array);

}
