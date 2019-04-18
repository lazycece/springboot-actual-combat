package com.lazycece.sbac.mysql.data.dao;

import com.lazycece.sbac.mysql.data.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @author lazycece
 * @date 2019/4/18
 */
@Repository
public interface UserDao {

    User insert(User user);
}
