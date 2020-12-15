package com.sicnu.wagesystems.repository;

import com.sicnu.wagesystems.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//只有class XXX


@SpringBootTest
public class AdminUserRepositoryTest {

    @Autowired
    private AdminUserRepository adminUserRepository;
    @Test
    void print()
    {
        List<AdminUser>  adminUserlist= adminUserRepository.findAll();
        for (AdminUser adminUser:adminUserlist) {
            System.out.println(adminUser);

        }
    }

}