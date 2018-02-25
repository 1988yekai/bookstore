package com.yek.myBookStore.repository;

import com.yek.myBookStore.entity.UserInfo;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * UserInfo持久化类
 * Created by yek on 2018-2-24.
 */
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
    /**
     * 通过username查找用户信息
     */
    UserInfo findByUsername(String username);

    PageImpl<UserInfo> findAll(Pageable pageable);
}
