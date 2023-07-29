package com.loafer.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel("用户信息修改请求类")
public class UserModifyDto {

    @NotNull(message = "用户ID不能为空！")
    @ApiModelProperty("用户ID")
    private Integer id;

    @NotEmpty(message = "用户名不能为空！")
    @ApiModelProperty("用户名")
    private String username;

    @NotEmpty(message = "密码不能为空！")
    @ApiModelProperty("密码")
    private String password;

    @NotEmpty(message = "电子邮件不能为空！")
    @ApiModelProperty("电子邮件")
    private String email;

    @NotEmpty(message = "名字不能为空！")
    @ApiModelProperty("名字")
    private String firstName;

    @NotEmpty(message = "姓氏不能为空！")
    @ApiModelProperty("姓氏")
    private String lastName;

    @ApiModelProperty("电话号码")
    private String phone;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("城市")
    private String city;

    @ApiModelProperty("州/省份")
    private String state;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("邮政编码")
    private String postalCode;
}
