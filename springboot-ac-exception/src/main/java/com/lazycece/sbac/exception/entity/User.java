package com.lazycece.sbac.exception.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lazycece
 * @date 2019/02/23
 */
@Setter
@Getter
@ToString
public class User {

    private String username;
    private String name;
    private Integer age;
}
