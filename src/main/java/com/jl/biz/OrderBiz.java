package com.jl.biz;


import com.jl.bean.CartVO;
import com.jl.bean.OrderInfo;
import com.jl.bean.OrderItemInfo;
import com.jl.repository.CartDAO;
import com.jl.repository.OrderDAO;
import com.jl.repository.OrderItemDAO;
import com.jl.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单业务类
 * @author peterlin
 *
 */
@Service
public class OrderBiz {

	@Autowired
	OrderDAO orderDAO;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	OrderItemDAO orderItemDAO;

	/**
	 * 生成订单
	 * @param o
	 * @param nos
	 * @param nums
	 * @return
	 * @throws Exception 
	 */

	@Transactional
	public int genOrder(OrderInfo o, String nos, String nums) throws Exception {
		String []cnos= StringUtil.splitString(nos, ",");
		String []cnums=StringUtil.splitString(nums, ",");
		if (null==cnos || cnos.length<=0) {
			return 0;
		}
		if (null==cnums ||cnums.length<=0) {
			return 0;
		}
		if (cnums.length != cnos.length) {
			return 0;
		}
		
		for (String cno : cnos) {
			System.out.println(cno);
		}
		//查看购物车信息
		List<CartVO> list=cartDAO.findByCnos(cnos);
		if (null==list||list.size()<0) {
				return 0;
		}

		double prices=0;//总价格
		//存储订单详情表数据的集合
		List<OrderItemInfo> items=new ArrayList<OrderItemInfo>();
		for (int i = 0; i < list.size(); i++) {//循环购物车中
			CartVO vo=list.get(i);
			OrderItemInfo item=new OrderItemInfo();
			item.setOno(o.getOno());//订单编号
			item.setGno(vo.getGno());//商品编号
			item.setNums(Integer.parseInt(cnums[i]));//数量来源于界面
			item.setPrice(vo.getPrice());//价格
			prices+=vo.getPrice()*Integer.parseInt(cnums[i]);//单价*界面传入的数量
			item.setStatus(1);
			items.add(item);
		}
		o.setPrice(prices);

		orderDAO.add(o);
		cartDAO.deleteByCnos(cnos);
		int result=orderItemDAO.addMultiple(items);
		return result;
	}

	public List<OrderInfo> getOrder(OrderInfo o) throws Exception {

		return orderDAO.findByTrem(o);
	}
	public int updateOrder(OrderInfo o) throws Exception {
		System.out.println(o);
		return orderDAO.update(o);
	}



}
