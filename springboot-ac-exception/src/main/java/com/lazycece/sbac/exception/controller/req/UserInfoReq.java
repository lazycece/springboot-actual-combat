package com.lazycece.sbac.exception.controller.req;

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
public class UserInfoReq {

    @NotBlank(message = "username不能为空")
    private String username;

    @NotBlank(message = "name不能为空")
    private String name;

    @NotNull(message = "age不能为null")
    @Min(value = 1, message = "年龄不符合要求")
    @Max(value = 200, message = "年龄不符合要求")
    private Integer age;
}
