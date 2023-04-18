package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("ref_user_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefUserRoleDO {

    private String id;

    private String userId;

    private String roleId;

}
