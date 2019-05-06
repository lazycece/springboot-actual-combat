package com.lazycece.sbac.mongodb.multi.repository;

import com.lazycece.sbac.mongodb.multi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * @author lazycece
 * @date 2019/05/06
 */
@Repository
public class UserRepository {

    private MongoTemplate mongoMasterTemplate;

    @Autowired
    public UserRepository(MongoTemplate mongoMasterTemplate) {
        this.mongoMasterTemplate = mongoMasterTemplate;
    }

    public void insert(User user) {
        mongoMasterTemplate.insert(user);
    }

    public User findByUsername(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        return mongoMasterTemplate.findOne(query, User.class);
    }
}
