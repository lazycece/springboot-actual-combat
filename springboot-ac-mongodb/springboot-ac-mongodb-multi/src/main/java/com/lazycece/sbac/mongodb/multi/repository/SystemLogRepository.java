package com.lazycece.sbac.mongodb.multi.repository;

import com.lazycece.sbac.mongodb.multi.entity.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author lazycece
 * @date 2019/05/06
 */
@Repository
public class SystemLogRepository {

    private MongoTemplate mongoLogTemplate;

    @Autowired
    public SystemLogRepository(MongoTemplate mongoLogTemplate) {
        this.mongoLogTemplate = mongoLogTemplate;
    }

    public void insert(SystemLog systemLog) {
        mongoLogTemplate.insert(systemLog);
    }

    public List<SystemLog> listLog(Date beginTime, Date endTime) {
        Query query = new Query();
        query.addCriteria(Criteria.where("createTime")
                .lte(endTime).gte(beginTime));
        return mongoLogTemplate.find(query, SystemLog.class);
    }
}
