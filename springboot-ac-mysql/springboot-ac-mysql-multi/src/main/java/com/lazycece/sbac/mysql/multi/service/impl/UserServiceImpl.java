package com.lazycece.sbac.mysql.multi.service.impl;

import com.lazycece.sbac.mysql.data.dao.UserDao;
import com.lazycece.sbac.mysql.data.domain.User;
import com.lazycece.sbac.mysql.multi.config.DataSource;
import com.lazycece.sbac.mysql.multi.config.MultiDataSource;
import com.lazycece.sbac.mysql.multi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lazycece
 * @date 2019/4/18
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @DataSource(value = MultiDataSource.MASTER_DATA_SOURCE)
    public void addUserInfo(User user) {

    }

    @Override
    @DataSource(value = MultiDataSource.SLAVE_DATA_SOURCE)
    public User getUserInfo(String username) {
        return null;
    }
}
