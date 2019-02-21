package com.lazycece.sbac.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author lazycece
 * @date 2018/10/16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "index", type = "doc")
public class User {

    private String id;
    private String username;
    private String name;
    private Integer age;
    private Date createTime = new Date();
    private Date updateTime = new Date();
}
