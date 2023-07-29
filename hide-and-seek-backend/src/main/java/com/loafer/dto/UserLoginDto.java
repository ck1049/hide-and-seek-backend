package com.loafer.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("用户登录请求类")
public class UserLoginDto {

    @NotEmpty(message = "邮箱不能为空！")
    private String email;

    @NotEmpty(message = "密码不能为空！")
    private String password;
}
