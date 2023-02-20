package com.example.serversystem.mongodb;

import com.example.basicsystem.entity.ResourceDO;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExamResourceRepository extends MongoRepository<ResourceDO,String> {

    ResourceDO getResourceDOByNum(Integer num);

    List<ResourceDO> getAllByType(Integer type);

    @Aggregation()
    Long sumAge();

}
