package com.sicnu.wagesystems;

import com.sicnu.wagesystems.entity.AdminUser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication  //可以添加exclude=xx.class来取消加载某个类
//@ComponentScan(basePackages = "")  由于上面这个注解包含comscan所以需要把controller
@MapperScan(basePackages = "com.sicnu.wagesystems.mapper")
//放到同一个包下,而这个注解可以指定扫描的包
public class WagesystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WagesystemsApplication.class, args);


    }

}
