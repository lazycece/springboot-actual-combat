package com.lazycece.sbac.mongodb.simple.repository;

import com.lazycece.sbac.mongodb.simple.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author lazycece
 * @date 2019/05/06
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
