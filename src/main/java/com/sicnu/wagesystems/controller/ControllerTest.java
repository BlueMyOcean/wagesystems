package com.sicnu.wagesystems.controller;

import com.sicnu.wagesystems.entity.NormalUser;
import com.sicnu.wagesystems.properties.AliyunProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ControllerTest {

    @Autowired   //@Resource(name="XX")
    private NormalUser normalUser;
    @Autowired
    private AliyunProperties aliyunProperties;

    @GetMapping("/test")
    public String helloworld()
    {
        return "Helloworld";
    }

    @GetMapping("/user")
    public NormalUser hellouser()
    {
        return normalUser;
    }

    @Value("${server.servlet.context-path}")
    private String path;
    @GetMapping("/info")
    public String path()
    {
        return path;
    }
//    @GetMapping("/aliyun")
//    public AliyunProperties aliyunProperties()
//    {
//        return aliyunProperties;
//    }

    @GetMapping("/aliyun")
    public List<AliyunProperties> aliyunProperties()
    {
        List<AliyunProperties> aliyunProperties = new ArrayList<>();
        AliyunProperties aliyunProperties1 = new AliyunProperties();
        aliyunProperties1.setName("123");
        aliyunProperties1.setPassword("123");

        AliyunProperties aliyunProperties2 = new AliyunProperties();
        aliyunProperties2.setName("123");
        aliyunProperties2.setPassword("123");

        aliyunProperties.add(aliyunProperties1);
        aliyunProperties.add(aliyunProperties2);

        return aliyunProperties;
    }

}
