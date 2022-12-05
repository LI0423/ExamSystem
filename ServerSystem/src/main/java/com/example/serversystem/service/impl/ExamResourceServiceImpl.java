package com.example.serversystem.service.impl;

import com.example.basicsystem.common.DictionaryData;
import com.example.basicsystem.entity.ResourceDO;
import com.example.basicsystem.utils.ConstantUtil;
import com.example.serversystem.dto.ResourceQueryDTO;
import com.example.serversystem.mongodb.ExamResourceRepository;
import com.example.serversystem.service.ExamResourceService;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExamResourceServiceImpl implements ExamResourceService {

    @Resource
    ExamResourceRepository examResourceRepository;

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public ResourceDO getResourceDOByNum(Integer num) {
        return examResourceRepository.getResourceDOByNum(num);
    }

    @Override
    public List<ResourceDO> getAllResourceByType(Integer type) {
        return examResourceRepository.getAllByType(type);
    }

    @Override
    public ResourceDO saveResourceDO(ResourceDO resourceDO) {
        return examResourceRepository.save(resourceDO);
    }

    @Override
    public Boolean saveResourceList(List<ResourceQueryDTO> list, String userId) {
        List<ResourceDO> resourceDOS = new ArrayList<>();
        if (ConstantUtil.listIsNotEmpty(list)) {
            for (ResourceQueryDTO queryDTO : list) {
                ResourceDO resourceDO = new ResourceDO();
                BeanUtils.copyProperties(queryDTO, resourceDO);
                resourceDO.setId(ConstantUtil.getPrimaryKey());
                resourceDO.setDelFlag(DictionaryData.UN_DELETE);
                resourceDO.setCreateBy(userId);
                resourceDO.setCreateDate(System.currentTimeMillis());
                resourceDOS.add(resourceDO);
            }
        }
        examResourceRepository.saveAll(resourceDOS);
        return null;
    }

    @Override
    public Boolean deleteResourceById(String id) {
        Query query = new Query(new Criteria("id").is(id));
        DeleteResult remove = mongoTemplate.remove(query);
        return remove.getDeletedCount() > 0;
    }


}
