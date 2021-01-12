package com.sicnu.wagesystems.util;

import com.sicnu.wagesystems.entity.OrdinaryUser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
public class SessionUtil {

    private HttpSession session;

    public boolean IsNew(HttpServletRequest request)
    {
        session = request.getSession();
        return session.isNew();
    }

    public void setUserSession(OrdinaryUser user, String type, HttpServletRequest request)
    {
        session = request.getSession();
        session.setAttribute(type,user);
        System.out.println("user已装入session");
        session.setMaxInactiveInterval(60 * 60);//最大不活跃时间
    }

    public Object getUserSession(String type,HttpServletRequest request) {
        session = request.getSession();
        return session.getAttribute(type);

    }

    public void destroySession(HttpServletRequest request)
    {
        session = request.getSession();
        session.invalidate();
        System.out.println("已摧毁session");
    }


}
