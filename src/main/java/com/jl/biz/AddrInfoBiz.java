package com.jl.biz;

import com.jl.bean.AddrInfo;
import com.jl.repository.AddrInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddrInfoBiz {

	@Autowired
	AddrInfoDao addrInfoDao;
	//查询地址
	public List<AddrInfo> getAddrInfo(AddrInfo t) throws Exception{
		return addrInfoDao.findByTrem(t);
	}
	//查询默认地址 1为默认
	public List<AddrInfo> getDefaultAddrInfo(AddrInfo t) throws Exception{
		t.setFlag(1);
		return addrInfoDao.findByTrem(t);
	}
	//添加地址
	public int InsertAddrInfos(AddrInfo t) throws Exception{
		UUID uuid=UUID.randomUUID();
		t.setAno(uuid.toString());
		t.setFlag(0);
		t.setStatus(1);
		return addrInfoDao.add(t);
	}
	//删除地址
	public int deleteAddrInfos(AddrInfo t) throws Exception{
		return addrInfoDao.delete(t);
	}

	//修改地址
	public int updateAddrInfos(AddrInfo t) throws Exception{
		System.out.println(t);
		return addrInfoDao.update(t);
	}
}
