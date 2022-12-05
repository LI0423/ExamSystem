package com.example.serversystem.mongodb;

import com.example.basicsystem.entity.ResourceDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ExamResourceRepository extends MongoRepository<ResourceDO,String> {

    ResourceDO getResourceDOByNum(Integer num);

    List<ResourceDO> getAllByType(Integer type);

}
