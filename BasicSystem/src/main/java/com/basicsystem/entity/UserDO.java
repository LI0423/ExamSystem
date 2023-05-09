package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private String userName;

    private String password;

    private String realName;

    private String phone;

    private String idCard;

    private String image;

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
