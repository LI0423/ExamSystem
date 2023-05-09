package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserDO {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String userName;

    private String password;

    private String phone;

    private String image;

    private Integer delFlag;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.UPDATE)
    private Long updateTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;
}
