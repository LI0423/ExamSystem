package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("ref_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefUserRoleDO {

    @TableId(type = IdType.AUTO)
    private String id;

    private String userId;

    private String roleId;

}
