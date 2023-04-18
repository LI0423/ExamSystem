package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("sys_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuDO {

    private Long id;

    private String permission;

    private Long parentId;

    private Integer delFlag;

    private String createBy;

    private Long createDate;

    private String updateBy;

    private Long updateDate;
}
