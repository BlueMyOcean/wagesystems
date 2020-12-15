package com.sicnu.wagesystems.service.imp;

import com.sicnu.wagesystems.entity.OrdinaryUser;
import com.sicnu.wagesystems.mapper.OrdinaryUserMapper;
import com.sicnu.wagesystems.service.dao.OrdinaryUserServiceDao;
import com.sicnu.wagesystems.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class OrdinaryUserServiceImp implements OrdinaryUserServiceDao {

    @Autowired
    private OrdinaryUserMapper ordinaryUserMapper;

    @Autowired
    private SessionUtil session;

    @Override
    public OrdinaryUser ordinaryUserLogin(String username, String password , HttpServletRequest request) {
//        System.out.println(username+" "+password);
        OrdinaryUser ordinaryUser = ordinaryUserMapper.findByUsername(username);
        if(ordinaryUser==null)
            return null;
        else {
            session.setUserSession(ordinaryUser, "OrdinaryUser", request);
            return ordinaryUser;
        }
    }

    @Override
    public boolean ordinaryUserRegister(OrdinaryUser user) {
        return false;

    }

    @Override
    public boolean ordinaryUserLogout(HttpServletRequest request) {

        try{
            session.destroySession(request);
            return true;
        }catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }


    }

}
