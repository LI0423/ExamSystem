package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("ref_role_menu")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RefRoleMenuDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long roleId;

    private Long menuId;

}
