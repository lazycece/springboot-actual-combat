package com.lazycece.sbac.elasticsearch.repository;

import com.lazycece.sbac.elasticsearch.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author lazycece
 * @date 2018/10/16
 */
public interface BookEsRepository extends ElasticsearchRepository<Book,String> {
    Book findByName(String name);
}
