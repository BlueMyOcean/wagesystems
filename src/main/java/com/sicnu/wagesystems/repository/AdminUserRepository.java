package com.sicnu.wagesystems.repository;

import com.sicnu.wagesystems.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//对接口名右键goto既可以创建测试
@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser,Integer> {
}
