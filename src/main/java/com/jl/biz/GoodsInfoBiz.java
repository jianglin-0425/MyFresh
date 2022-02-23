package com.jl.biz;

import com.jl.bean.GoodsInfo;
import com.jl.bean.GoodsType;
import com.jl.bean.GoodsVO;
import com.jl.config.MyConfig;
import com.jl.repository.GoodsInfoDao;
import com.jl.repository.GoodsTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsInfoBiz {

	@Autowired
	GoodsInfoDao dao;
	@Autowired
	GoodsTypeDAO typeDAO;

	public int add(GoodsInfo t) throws SQLException {
			return dao.add(t);
	}
	public Map<String,Object> findByPage(GoodsVO v, Integer pageNum, Integer pageSize) throws Exception {
		List<GoodsVO> list=dao.findByPage(v,pageNum,pageSize);
		int total=dao.getTotal(v);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", list);
		return map;
	}
	public Map<String, Object> finds() throws Exception{
		List<GoodsInfo> goods=dao.finds();

		List<GoodsType> types=typeDAO.findByTrem(null);
		for (GoodsInfo info:goods) {
			info.setPics(MyConfig.fileUrl +info.getPics());
		}
		for (int i = 0; i < types.size(); i++) {
			for (GoodsInfo info : goods) {
				if (types.get(i).getTno().equals(info.getTno())) {
					types.get(i).setStatus(2);
					break;
				}
			}
		}

		Map<String, Object> map=new HashMap<>();
		map.put("goods", goods);
		map.put("types", types);
		return map;
	}

	public GoodsInfo findSingle(String gno) {
		GoodsInfo t=new GoodsInfo();
		Integer g=Integer.parseInt(gno);
		t.setGno(g);
		List<GoodsInfo> list=null;
		try {
			list=dao.findByTrem(t);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.get(0).setPics(MyConfig.fileUrl+list.get(0).getPics());
		return list.get(0);
	}
	/**
	 * 查询多条goods
	 * @param list
	 * @return
	 */
	public List<GoodsInfo> findMulit(List<GoodsInfo> list){
		List<GoodsInfo> goods=new ArrayList<GoodsInfo>();
		for (GoodsInfo l : list) {
			try {
				goods.add(dao.findByTrem(l).get(0));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (GoodsInfo good:goods) {
			good.setPics(MyConfig.fileUrl+good.getPics());
		}
		return goods;
	}
}
