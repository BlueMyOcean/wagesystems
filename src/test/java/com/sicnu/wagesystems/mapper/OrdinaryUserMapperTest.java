package com.sicnu.wagesystems.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sicnu.wagesystems.WagesystemsApplicationTests;
import com.sicnu.wagesystems.entity.OrdinaryUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class OrdinaryUserMapperTest extends WagesystemsApplicationTests {

    @Autowired
    private OrdinaryUserMapper ordinaryUserMapper;

    @Test
    void findAll() {
        List<OrdinaryUser> list = ordinaryUserMapper.findAll();
        for (OrdinaryUser ordinary:list
             ) {
            System.out.println(ordinary);

        }
    }

    @Test
    void findByUsername() {
        OrdinaryUser ordinaryUser = ordinaryUserMapper.findByUsername("sss");
        System.out.println(ordinaryUser);
    }

    @Test
    void splitByPage()
    {
        PageHelper.startPage(1,10);
        List<OrdinaryUser> ordinaryUserList = ordinaryUserMapper.findAll();
        PageInfo<OrdinaryUser> pageInfo = new PageInfo<>(ordinaryUserList);
        for (OrdinaryUser ordinaryUser : pageInfo.getList()) {
            System.out.println(ordinaryUser);
        }
    }
}