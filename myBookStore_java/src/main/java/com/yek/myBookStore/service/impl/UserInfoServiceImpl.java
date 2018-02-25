package com.yek.myBookStore.service.impl;

import com.yek.myBookStore.entity.UserInfo;
import com.yek.myBookStore.repository.UserInfoRepository;
import com.yek.myBookStore.service.UserInfoService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Created by yek on 2018-2-24.
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoRepository userInfoRepository;

    @Transactional(readOnly=true)
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoRepository.findByUsername(username);
    }
    public void insertUserInfo(UserInfo userInfo){
        UserInfo save = userInfoRepository.save(userInfo);
        System.out.println(save);
    }

    @Override
    public List<UserInfo> findAllUserInfo() {
        Iterator<UserInfo> iterator = userInfoRepository.findAll().iterator();
        List<UserInfo> userInfoList = new ArrayList<>(50);
        while (iterator.hasNext()){
            userInfoList.add(iterator.next());
        }
        return userInfoList;
    }

    @Override
    public PageImpl<UserInfo> findAllUserInfoByPage() {
        Sort sort = new Sort(Sort.Direction.ASC, "uid");
        Pageable pageable = PageRequest.of(0,2,sort);
        PageImpl<UserInfo> page = userInfoRepository.findAll(pageable);
        return page;
    }

}
