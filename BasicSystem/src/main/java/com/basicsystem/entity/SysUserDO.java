package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDO {

    private Long id;

    private String userName;

    private String password;

    private String phone;

    private String image;

    private Integer delFlag;

    private Integer status;

    private Long createTime;

    private String createBy;

    private Long updateTime;

    private String updateBy;
}
