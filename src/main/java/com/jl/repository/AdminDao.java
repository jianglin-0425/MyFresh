package com.jl.repository;

import com.jl.bean.AdminInfo;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface AdminDao {


	public List<AdminInfo> findByTrem(AdminInfo t) ;
	
	public List<AdminInfo> findByPage(@Param("admin") AdminInfo t, @Param("pageSize") Integer pageSize,@Param("pageNum") Integer pageNum);



	/**
	 * 查询个数
	 * @param t
	 * @return
	 * @throws IOException 
	 * @throws SQLException 
	 */
	public Integer getTotal(AdminInfo t) ;

}
