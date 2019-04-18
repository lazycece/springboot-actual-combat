package com.lazycece.sbac.mysql.data.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lazycece
 * @date 2019/4/18
 */
@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private String telephone;
    private String editor;
    private Status status;
    private Date createTime;
    private Date updateTime;
}
