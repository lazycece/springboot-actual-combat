package com.lazycece.sbac.exception.service.impl;

import com.lazycece.sbac.exception.entity.User;
import com.lazycece.sbac.exception.exception.ParamException;
import com.lazycece.sbac.exception.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author lazycece
 * @date 2019/02/23
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUserInfo(String username) {

        if (StringUtils.isEmpty(username)) {
            throw new ParamException("username is empty");
        }

        User user = new User();
        user.setAge(200);
        user.setName("W");
        user.setUsername(username);
        return user;
    }
}
