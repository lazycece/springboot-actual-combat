package com.lazycece.sbac.rocketmq.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lazycece
 * @date 2019/04/04
 */
@Data
public class Message<T> implements Serializable {
    private String id;
    private T content;
}
