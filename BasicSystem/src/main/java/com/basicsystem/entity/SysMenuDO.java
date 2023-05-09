package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("sys_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String permission;

    private Long parentId;

    private Integer delFlag;

    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    @TableField(fill = FieldFill.INSERT)
    private Long createDate;

    @TableField(fill = FieldFill.UPDATE)
    private String updateBy;

    @TableField(fill = FieldFill.UPDATE)
    private Long updateDate;
}
