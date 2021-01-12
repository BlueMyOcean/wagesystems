package com.sicnu.wagesystems.controller;


import com.alibaba.fastjson.JSON;
import com.sicnu.wagesystems.entity.OrdinaryUser;
import com.sicnu.wagesystems.service.dao.OrdinaryUserServiceDao;
import com.sicnu.wagesystems.util.String2Date;
import org.springframework.beans.factory.annotation.Autowired;
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
        OrdinaryUser ordinaryUser= ordinaryUserServiceDao.ordinaryUserLogin(params.get("username").toString(),params.get("password").toString(),httpRequest);
        if(ordinaryUser!=null) {
            String userJson = JSON.toJSONString(ordinaryUser);
            System.out.println(ordinaryUser.getBirthday().toString());
            String s ="{\n" +
                    "  \"username\": "+ordinaryUser.getUsername()+",\n" +
                    "  \"id\":"+ ordinaryUser.getId()+",\n" +
                    "  \"card_id\":"+ ordinaryUser.getCardId()+",\n" +
                    "  \"id_card_num\":"+ ordinaryUser.getIdCardNum()+",\n" +
                    "  \"address\":"+ "\""+ordinaryUser.getAddress()+"\""+",\n" +
                    "  \"birthday\":"+ ordinaryUser.getBirthday().toString().replace("-","")+",\n" +
                    "  \"gender\":"+ "\""+ordinaryUser.getGender()+"\""+",\n" +
                    "  \"native_palce\":"+ ordinaryUser.getNative_Place()+",\n" +
                    "  \"folk\":"+ "\""+ordinaryUser.getFolk()+"\""+",\n" +
                    "  \"education\":"+"\""+ ordinaryUser.getEducation()+"\""+",\n" +
                    "  \"major\":"+"\""+ ordinaryUser.getMajor()+"\""+",\n" +
                    "  \"zip_code\":"+  "\""+ordinaryUser.getZipCode()+"\""+",\n" +
                    "  \"phone_num\":"+ "\""+ordinaryUser.getPhoneNum()+"\""+",\n" +
                    "  \"point\": 0,\n" +
                    "  \"mobile\": \"\",\n" +
                    "  \"is_mobile_valid\": true,\n" +
                    "  \"is_email_valid\": false,\n" +
                    "  \"is_active\": 1,\n" +
                    "  \"gift_amount\": 3,\n" +
                    "  \"email\": \"\",\n" +
                    "  \"delivery_card_expire_days\": 0,\n" +
                    "  \"current_invoice_id\": 0,\n" +
                    "  \"current_address_id\": 0,\n" +
                    "  \"brand_member_new\": 0,\n" +
                    "  \"balance\": 0,\n" +
                    "  \"avatar\": \"/img/default/default.jpg\",\n" +
                    "  \"status\": 1,\n" +
                    "  \"__v\": 0\n" +
                    "}";

            return s;
        } else{
            return "{\n" +
                    "\t\"status\": 0,\n" +
                    "\t\"type\": \"GET_ERROR_PARAM\",\n" +
                    "\t\"message\": \"用户不存在或密码错误\"\n" +
                    "}";
        }
//        System.out.println(params.get("username").toString()+" "+params.get("password").toString());
//        System.out.println(userJson);



    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest)
    {
        ordinaryUserServiceDao.ordinaryUserLogout(httpServletRequest);
        return "{\n" +
                "  \"status\": 1,\n" +
                "  \"message\": '退出成功'\n" +
                "}";

    }

    @PostMapping("/register")
    public String register(@RequestBody Map<String, Object> params, HttpServletRequest httpRequest)
    {
        OrdinaryUser ordinaryUser = new OrdinaryUser();
        ordinaryUser.setGender(Integer.parseInt(params.get("gender").toString()));
        ordinaryUser.setName(params.get("name").toString());
        ordinaryUser.setUsername(params.get("username").toString());
        ordinaryUser.setPassword(params.get("password").toString());
        ordinaryUser.setBirthday(String2Date.strToDate(params.get("birthday").toString()));
        ordinaryUser.setCardId(params.get("cardId").toString());

        boolean res = ordinaryUserServiceDao.ordinaryUserRegister(ordinaryUser,httpRequest);
        System.out.println("已经被调用了");
        if(res) {
            return "{\n" +
                    "  \"status\": 1,\n" +
                    "  \"message\":" + "\"" + "注册成功" + "\"" +
                    "}";
        }

        else {

            return "{\n" +
                    "  \"status\": 0,\n" +
                    "  \"message\":" + "\"" + "注册失败" + "\"" +
                    "}";

    }

    }


}

