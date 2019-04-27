package com.lazycece.sbac.mysql.data.dao.master;

import com.lazycece.sbac.mysql.data.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lazycece
 * @date 2019/4/18
 */
@Mapper
public interface UserDao {

    User insert(User user);

    User findByUsername(@Param("username") String username);
}
