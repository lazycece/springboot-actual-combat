package com.lazycece.sbac.validation.controller.req;

import com.lazycece.sbac.validation.constraint.Enum;
import com.lazycece.sbac.validation.enums.Role;
import com.lazycece.sbac.validation.enums.Sex;
import com.lazycece.sbac.validation.group.Update;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

/**
 * @author lazycece
 * @date 2019/02/15
 */
@Setter
@Getter
@ToString
public class UserInfoReq {

    @NotNull(message = "id不能为null", groups = {Update.class})
    private Long id;

    @NotBlank(message = "username不能为空")
    private String username;

    @NotNull(message = "age不能为null")
    @Min(value = 1, message = "年龄不符合要求")
    @Max(value = 200, message = "年龄不符合要求")
    private Integer age;

    @Enum(clazz = Sex.class, message = "sex参数错误")
    private Integer sex;

    @Enum(clazz = Role.class, method = "getValue", message = "role参数错误")
    private Integer role;
}
