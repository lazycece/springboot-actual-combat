package com.lazycece.sbac.exception.service;

import com.lazycece.sbac.exception.entity.User;

/**
 * @author lazycece
 * @date 2019/02/23
 */
public interface UserService {

    User getUserInfo(String username);
}
