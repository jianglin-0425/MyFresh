package com.jl.biz;


import com.jl.bean.OrderItemInfo;
import com.jl.bean.OrderItemVO;
import com.jl.config.MyConfig;
import com.jl.repository.OrderItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemBiz {
	@Autowired
	OrderItemDAO dao;
	/**
	 * 得到orderitem
	 * @param o
	 * @return
	 */
	public List<OrderItemInfo> getOrderItem(OrderItemInfo o) {
		List<OrderItemInfo> list=null;
		try {
			list=dao.findByTrem(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<OrderItemVO> getItemVO(OrderItemInfo o) {
		List<OrderItemVO> list=null;
		try {
			list=dao.findItemVO(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (OrderItemVO vo:list) {
			vo.setPics(MyConfig.fileUrl +vo.getPics());
		}
		return list;
	}
}
