package com.serversystem.service.impl;

import com.basicsystem.common.DictionaryData;
import com.basicsystem.entity.ResourceDO;
import com.basicsystem.utils.ConstantUtil;
import com.serversystem.dto.ResourceQueryDTO;
import com.serversystem.service.ExamResourceService;
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
    MongoTemplate mongoTemplate;

    @Override
    public ResourceDO getResourceDOByNum(Integer num) {
        Query query = new Query();
        query.addCriteria(Criteria.where("num").is(num));
        return mongoTemplate.findOne(query, ResourceDO.class);
    }

    @Override
    public List<ResourceDO> getAllResourceByType(Integer type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("type").is(type));
        return mongoTemplate.find(query, ResourceDO.class);
    }

    @Override
    public ResourceDO saveResourceDO(ResourceDO resourceDO) {
        return mongoTemplate.save(resourceDO);
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
        mongoTemplate.save(resourceDOS);
        return null;
    }

    @Override
    public Boolean deleteResourceById(String id) {
        Query query = new Query(new Criteria("id").is(id));
        DeleteResult remove = mongoTemplate.remove(query);
        return remove.getDeletedCount() > 0;
    }


}
