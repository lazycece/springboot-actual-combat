package com.lazycece.sbac.response.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author lazycece
 * @date 2019/02/22
 */
@Data
public class User {

    private String id;
    private String username;
    private String name;
    private Integer age;
    private Date createTime = new Date();
    private Date updateTime = new Date();
}