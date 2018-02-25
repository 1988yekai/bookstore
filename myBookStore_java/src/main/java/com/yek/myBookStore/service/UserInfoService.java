package com.yek.myBookStore.service;

import com.yek.myBookStore.entity.UserInfo;
import org.springframework.data.domain.PageImpl;

import java.util.List;

/**
 * Created by Administrator on 2018-2-24.
 */
public interface UserInfoService {
    UserInfo findByUsername(String username);
    void insertUserInfo(UserInfo userInfo);
    List<UserInfo> findAllUserInfo();
    PageImpl<UserInfo> findAllUserInfoByPage();
}
