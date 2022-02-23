package com.jl.repository;

import com.jl.bean.MenberInfo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenberDao {


	public List<MenberInfo> findByTrem(MenberInfo t) ;

	public List<MenberInfo> findByPage(@Param("member") MenberInfo t,@Param("pageSize") Integer pageSize,@Param("pageNum") Integer pageNum) ;

	public int getTotal(MenberInfo t);

}
