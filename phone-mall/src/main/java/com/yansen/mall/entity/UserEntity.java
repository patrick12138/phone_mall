package com.yansen.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("user")
public class UserEntity {
    @TableId
    private Integer id;
    private String username;
    private String password;
    private String phone;
}
