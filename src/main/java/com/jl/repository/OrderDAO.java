package com.jl.repository;

import com.jl.bean.OrderInfo;
import com.jl.bean.OrderItemInfo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO {


	public int add(OrderInfo t) ;

	public List<OrderInfo> findByTrem(OrderInfo t) ;

	public int update(OrderInfo t) ;

	public int delete(OrderInfo t) ;

	/**
	 * 生成订单
	 * @param o
	 * @param items
	 * @param cnos
	 * @return
	 * @throws Exception
	 */
	public int genOrder(@Param("order") OrderInfo o, @Param("items") List<OrderItemInfo> items, @Param("cons") String[] cnos);

}
