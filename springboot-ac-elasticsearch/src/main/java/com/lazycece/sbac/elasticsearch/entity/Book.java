package com.lazycece.sbac.elasticsearch.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author lazycece
 * @date 2018/10/16
 */
@Data
@Builder
@Document(indexName = "test_index_shard_5_2",type = "doc")
public class Book {

    private String id;
    private String name;
    private Date reportTime =new Date();
    private Integer page;
    private String desc;
}
