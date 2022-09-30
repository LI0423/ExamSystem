package com.example.serversystem.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.basicsystem.entity.SysUserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUserDO> {
}
