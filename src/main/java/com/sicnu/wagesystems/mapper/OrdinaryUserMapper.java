package com.sicnu.wagesystems.mapper;

import com.sicnu.wagesystems.entity.OrdinaryUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper

@Component
public interface OrdinaryUserMapper {

    List<OrdinaryUser> findAll();
    OrdinaryUser findByUsername(String username);
}
