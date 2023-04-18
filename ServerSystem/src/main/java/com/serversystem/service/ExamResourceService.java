package com.serversystem.service;

import com.basicsystem.entity.ResourceDO;
import com.serversystem.dto.ResourceQueryDTO;

import java.util.List;

public interface ExamResourceService  {

    ResourceDO getResourceDOByNum(Integer num);

    List<ResourceDO> getAllResourceByType(Integer type);

    ResourceDO saveResourceDO(ResourceDO resourceDO);

    Boolean saveResourceList(List<ResourceQueryDTO> list, String userId);

    Boolean deleteResourceById(String id);



}
