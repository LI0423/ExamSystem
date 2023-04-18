package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDO {

    private Long id;

    private String userName;

    private String password;

    private String realName;

    private String phone;

    private String idCard;

    private String image;

    private Integer delFlag;

    private String createBy;

    private Long createDate;

    private String updateBy;

    private Long updateDate;

}
