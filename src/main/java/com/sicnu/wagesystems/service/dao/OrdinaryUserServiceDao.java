package com.sicnu.wagesystems.service.dao;

import com.sicnu.wagesystems.entity.OrdinaryUser;

import javax.servlet.http.HttpServletRequest;

public interface OrdinaryUserServiceDao {

    OrdinaryUser ordinaryUserLogin(String username, String password, HttpServletRequest request);
    boolean ordinaryUserRegister(OrdinaryUser user,HttpServletRequest request);
    boolean ordinaryUserLogout(HttpServletRequest request);
}
