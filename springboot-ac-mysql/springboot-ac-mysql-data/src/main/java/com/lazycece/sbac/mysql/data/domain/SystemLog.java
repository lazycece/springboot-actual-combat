package com.lazycece.sbac.mysql.data.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author lazycece
 * @date 2019/04/25
 */
@Data
@ToString
public class SystemLog {

    private Long id;
    private String editor;
    private String operation;
    private Date createTime;
}
