package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("sys_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleDO {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String name;

    private String roleIdentify;

    private Integer type;

    private Integer delFlag;

    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.UPDATE)
    private Long updateTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

}
