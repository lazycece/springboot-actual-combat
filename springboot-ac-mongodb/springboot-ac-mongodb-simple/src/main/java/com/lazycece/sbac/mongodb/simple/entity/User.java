package com.lazycece.sbac.mongodb.simple.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author lazycece
 * @date 2019/4/18
 */
@Data
@ToString
@Document(collection = "user")
public class User {

    private String id;
    private String username;
    private String password;
    private String telephone;
    private String editor;
    private Date createTime;
    private Date updateTime;
}
