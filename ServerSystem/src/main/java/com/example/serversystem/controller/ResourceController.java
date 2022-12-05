package com.example.serversystem.controller;

import com.example.basicsystem.common.BasicController;
import com.example.basicsystem.common.ResponseResult;
import com.example.serversystem.dto.ResourceQueryDTO;
import com.example.serversystem.service.ExamResourceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/server/exam/resource")
@RestController
public class ResourceController extends BasicController {

    @Resource
    ExamResourceService examResourceService;

    @PostMapping("/add")
    public ResponseResult addResource(@RequestParam("queryList") List<ResourceQueryDTO> queryList){
        String userId = getUserId();
        Boolean aBoolean = examResourceService.saveResourceList(queryList, userId);
        return ResponseResult.newResultEntity(aBoolean);
    }

}
