package com.lazycece.sbac.elasticsearch.repository;

import com.lazycece.sbac.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author lazycece
 * @date 2018/10/16
 */
public interface UserEsRepository extends ElasticsearchRepository<User,String> {
    User findByUsername(String name);
}
