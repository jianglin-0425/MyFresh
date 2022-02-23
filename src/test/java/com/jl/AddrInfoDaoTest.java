package com.jl;

import com.jl.bean.AddrInfo;
import com.jl.repository.AddrInfoDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AddrInfoDaoTest {

    @Autowired
    AddrInfoDao dao;

    @Test
    void findByTrem() {
        AddrInfo addrInfo=new AddrInfo();
        addrInfo.setAno("1");
        List<AddrInfo>  info=dao.findByTrem(addrInfo);
        System.out.println(info.size());
        for (AddrInfo i:info) {
            System.out.println(i);
        }
        //Assert.notNull(info);
    }

    @Test
    void update() {
        AddrInfo addrInfo=new AddrInfo();
        addrInfo.setAno("1");

    }

    @Test
    void delete() {
        AddrInfo addrInfo=new AddrInfo();
        addrInfo.setAno("2");
        System.out.println(dao.delete(addrInfo));
    }


}