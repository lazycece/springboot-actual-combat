package com.lazycece.sbac.validation.controller.req;

import com.lazycece.sbac.validation.constraint.Enum;
import com.lazycece.sbac.validation.enums.Role;
import com.lazycece.sbac.validation.enums.Sex;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author lazycece
 * @date 2019/02/15
 */
@Setter
@Getter
public class UserInfoReq {

    @NotBlank(message = "username不能为空")
    private String username;
    //    @NotNull(message = "age不能为null")
//    @Size(min = 1, max = 200, message = "年龄不符合要求")
    private int age;
    @Enum(clazz = Sex.class, message = "sex参数错误")
    private Integer sex;
    @Enum(clazz = Role.class, method = "getValue", message = "role参数错误")
    private Integer role;
}
