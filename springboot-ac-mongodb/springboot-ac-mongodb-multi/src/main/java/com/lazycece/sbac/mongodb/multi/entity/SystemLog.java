package com.lazycece.sbac.mongodb.multi.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author lazycece
 * @date 2019/04/25
 */
@Data
@ToString
@Document(collection = "system_log")
public class SystemLog {

    private String id;
    private String editor;
    private String operation;
    private Date createTime;
}
