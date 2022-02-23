package com.jl.repository;

import com.jl.bean.OrderItemInfo;
import com.jl.bean.OrderItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemDAO {


	public int add(OrderItemInfo t) ;

	public int addMultiple(List<OrderItemInfo> list);

	public List<OrderItemInfo> findByTrem(OrderItemInfo t) ;


	public int update(OrderItemInfo t) ;


	public int delete(OrderItemInfo t) ;

	public List<OrderItemVO> findItemVO(OrderItemInfo item);

}
