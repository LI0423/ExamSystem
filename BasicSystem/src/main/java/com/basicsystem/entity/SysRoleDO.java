package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("sys_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleDO {

    private Long id;

    private String name;

    private String roleIdentify;

    private Integer type;

    private Integer delFlag;

    private Long createTime;

    private String createBy;

    private Long updateTime;

    private String updateBy;

}
