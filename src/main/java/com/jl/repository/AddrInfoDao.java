package com.jl.repository;

import com.jl.bean.AddrInfo;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddrInfoDao {

	int add(AddrInfo t);

	/**
	 * 分类查询
	 * @param t
	 * @return
	 */
	 List<AddrInfo> findByTrem(AddrInfo t);

	/**
	 * 更新地址
	 * @param t
	 * @return
	 */
	 int update(AddrInfo t);

	/**
	 * 删除地址
	 * @param t
	 * @return
	 */
	int delete(AddrInfo t);

}
