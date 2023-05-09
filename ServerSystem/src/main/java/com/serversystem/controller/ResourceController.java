package com.serversystem.controller;

import com.basicsystem.common.ResponseResult;
import com.serversystem.common.BasicController;
import com.serversystem.dto.ResourceQueryDTO;
import com.serversystem.service.ExamResourceService;
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
//        String userId = getUserId();
        Boolean aBoolean = examResourceService.saveResourceList(queryList, "userId");
        return ResponseResult.newResultEntity(aBoolean);
    }

}
