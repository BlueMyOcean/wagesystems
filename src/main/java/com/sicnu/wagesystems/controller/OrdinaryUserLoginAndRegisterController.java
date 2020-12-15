package com.sicnu.wagesystems.controller;


import com.alibaba.fastjson.JSON;
import com.sicnu.wagesystems.entity.OrdinaryUser;
import com.sicnu.wagesystems.service.dao.OrdinaryUserServiceDao;
import com.sicnu.wagesystems.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/ordinary")
@CrossOrigin
public class OrdinaryUserLoginAndRegisterController {

    @Autowired
    private OrdinaryUserServiceDao ordinaryUserServiceDao;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody Map<String, Object> params, HttpServletRequest httpRequest)
    {
        String userJson = JSON.toJSONString(ordinaryUserServiceDao.ordinaryUserLogin(params.get("username").toString(),params.get("password").toString(),httpRequest));
//        System.out.println(params.get("username").toString()+" "+params.get("password").toString());
        return userJson;
    }
    @PostMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest)
    {
        ordinaryUserServiceDao.ordinaryUserLogout(httpServletRequest);
        return "{"
            +"status:200,"
        +"message:{ " +
                "isSuccess:true}" +
                "}";

    }
}

