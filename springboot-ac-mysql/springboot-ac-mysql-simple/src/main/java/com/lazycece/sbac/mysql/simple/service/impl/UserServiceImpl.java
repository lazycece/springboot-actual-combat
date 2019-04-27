package com.lazycece.sbac.mysql.simple.service.impl;

import com.lazycece.sbac.mysql.data.dao.master.UserDao;
import com.lazycece.sbac.mysql.data.domain.User;
import com.lazycece.sbac.mysql.simple.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/4/18
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public void addUserInfo(User user) {
        userDao.insert(user);
    }

    @Override
    public User getUserInfo(String username) {
        return userDao.findByUsername(username);
    }
}
