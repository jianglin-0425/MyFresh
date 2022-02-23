package com.jl.biz;

import com.jl.bean.CartInfo;
import com.jl.bean.CartVO;
import com.jl.repository.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartBiz {

	@Autowired
	CartDAO dao;
	
	/**
	 * 根据会员编号查看购物车
	 * @param mno
	 * @return
	 * @throws Exception
	 */
	public List<CartVO> findByMnoVO(int mno) throws Exception {
		CartVO vo=new CartVO();
		vo.setMno(mno);
		return dao.findVoByTrem(vo);
	}
	/**
	 * 根据会员编号查看购物车
	 * @param mno
	 * @return
	 * @throws Exception
	 */
	public List<CartInfo> findByMno(int mno) throws Exception {
		CartInfo vo=new CartInfo();
		vo.setMno(mno);
		return dao.findByTrem(vo);
	}
	/**
	 * 添加购物车
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int  add(CartInfo t) throws Exception {
		List<CartInfo> list=dao.findByTrem(t);
		if (null!=list&&list.size()>0) {
			return dao.update(t);
		}
		return dao.add(t);
	}
	/**
	 * 删除购物车
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int delete(CartInfo t) throws Exception {
		return dao.delete(t);
	}
	/**
	 * 修改购物车
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public int updateCart(CartInfo t) throws Exception {
		return dao.update(t);
	}
}
