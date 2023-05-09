package com.basicsystem.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDO {

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    //题号
    private Integer num;

    //问题
    private String question;

    //选项
    private String choices;

    //答案
    private String answer;

    //分数
    private String score;

    //类型，1-单选，2-多选，3-判断
    private Integer type;

    //
    private Integer sectionType;

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
