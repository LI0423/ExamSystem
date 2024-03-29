package com.exam.filesystem.controller;

import com.basicsystem.common.ResponseResult;
import com.exam.filesystem.service.MinioService;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Controller
@RequestMapping("/obs")
public class UploadController {

    @Autowired
    MinioService minioService;

    /**
     * 上传文件
     *
     * @param file
     * @param bucketName
     * @return
     */
    @PostMapping("/upload/file")
    public ResponseResult uploadFile(MultipartFile file, String bucketName) {
        String s = minioService.uploadFile(file, bucketName);
        return ResponseResult.newResultEntity(s);
    }

    /**
     * 判断桶是否存在
     *
     * @param bucketName
     * @return
     */
    @ResponseBody
    @GetMapping("/bucket/exist")
    public ResponseResult bucketExist(@RequestParam("bucketName") String bucketName) {
        Boolean aBoolean = minioService.bucketExist(bucketName);
        return ResponseResult.newResultEntity(aBoolean);
    }

    /**
     * 下载文件
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    @ResponseBody
    @GetMapping("/download/file")
    public ResponseResult downloadFile(@RequestParam("bucketName") String bucketName,
                                       @RequestParam("objectName") String objectName) {
        InputStream inputStream = minioService.downLoadFile(bucketName, objectName);
        return ResponseResult.newResultEntity(inputStream);
    }

    /**
     * 删除文件
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    @PostMapping("/remove/file")
    public ResponseResult removeFile(@RequestParam("bucketName") String bucketName,
                                     @RequestParam("objectName") String objectName) {
        Boolean aBoolean = minioService.removeFile(bucketName, objectName);
        return ResponseResult.newResultEntity(aBoolean);
    }

    /**
     * 删除桶
     *
     * @param bucketName
     * @return
     */
    @PostMapping("/remove/bucket")
    public ResponseResult removeBucket(@RequestParam("bucketName") String bucketName) {
        Boolean aBoolean = minioService.removeBucket(bucketName);
        return ResponseResult.newResultEntity(aBoolean);
    }

    /**
     * 获取文件路径
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    @ResponseBody
    @GetMapping("/get/object/url")
    public ResponseResult getObjectUrl(@RequestParam("bucketName") String bucketName,
                                       @RequestParam("objectName") String objectName) {
        String objectUrl = minioService.getObjectUrl(bucketName, objectName);
        return ResponseResult.newResultEntity(objectUrl);
    }

    /**
     * 获取桶下文件列表
     *
     * @param bucketName
     * @return
     */
    @ResponseBody
    @GetMapping("/get/object/list")
    public ResponseResult getObjectList(@RequestParam("bucketName") String bucketName) {
        Iterable<Result<Item>> objectList = minioService.getObjectList(bucketName);
        return ResponseResult.newResultEntity(objectList);
    }

}
