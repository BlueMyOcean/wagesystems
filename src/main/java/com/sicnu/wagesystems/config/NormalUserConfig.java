package com.sicnu.wagesystems.config;

import com.sicnu.wagesystems.entity.NormalUser;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  //配置类 用于取代 XML 来配置 Spring
public class NormalUserConfig {

    @Bean
    public Session sessionReturn()
    {
        return new Session();
    }
    @Bean  //构建一个对象，放入spring容器中  默认方法名也可以name="xxx"指定
    public NormalUser normalUserReturn()
    {
        NormalUser normalUser = new NormalUser();
        normalUser.setID(1);
        normalUser.setName("张三");
        return normalUser;
    }
}
