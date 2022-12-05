package com.example.serversystem.service;

import com.example.basicsystem.entity.ResourceDO;
import com.example.serversystem.dto.ResourceQueryDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExamResourceService  {

    ResourceDO getResourceDOByNum(Integer num);

    List<ResourceDO> getAllResourceByType(Integer type);

    ResourceDO saveResourceDO(ResourceDO resourceDO);

    Boolean saveResourceList(List<ResourceQueryDTO> list, String userId);

    Boolean deleteResourceById(String id);



}
