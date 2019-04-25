package com.lazycece.sbac.mysql.data.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author lazycece
 * @date 2019/4/18
 */
@Data
@ToString
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
