package com.lazycece.sbac.swagger2.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author lazycece
 * @date 2019/1/31
 */
@Data
@ToString
@ApiModel
public class UserInfoReq {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "年龄[0,200]", required = true, allowableValues = "range[0,200]", example = "1")
    private Integer age;

    @ApiModelProperty(value = "性别", required = true, allowableValues = "0,1,2")
    private String sex;
}
