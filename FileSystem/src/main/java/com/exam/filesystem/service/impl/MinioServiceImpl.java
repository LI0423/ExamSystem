package com.exam.filesystem.service.impl;

import com.exam.filesystem.Utils.FileTypeUtils;
import com.exam.filesystem.Utils.MinioUtils;
import com.exam.filesystem.config.MinioProperties;
import com.exam.filesystem.service.MinioService;
import io.minio.Result;
import io.minio.messages.Item;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service
public class MinioServiceImpl implements MinioService {

    @Autowired
    MinioUtils minioUtils;

    @Autowired
    MinioProperties minioProperties;

    @Override
    public String uploadFile(MultipartFile multipartFile, String bucketName) {
        if (StringUtils.isEmpty(bucketName)) {
            bucketName = minioProperties.getBucketName();
        }
        if (!minioUtils.bucketExists(bucketName)) {
            return "bucket 不存在！！！";
        }
        String fileName = multipartFile.getOriginalFilename();
        String objectName = "测试" + "-" + System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
        String fileType = FileTypeUtils.getFileType(multipartFile);
        minioUtils.putObject(bucketName, multipartFile, objectName, fileType);

        return minioProperties.getEndpoint() + "/" + bucketName + "/" + objectName;
    }

    @Override
    public Boolean bucketExist(String bucketName) {
        return minioUtils.bucketExists(bucketName);
    }

    @Override
    public InputStream downLoadFile(String bucketName, String objectName) {
        return minioUtils.getObject(bucketName, objectName);
    }

    @Override
    public Boolean removeFile(String bucketName, String objectName) {
        return minioUtils.removeObject(bucketName, objectName);
    }

    @Override
    public Boolean removeBucket(String bucketName) {
        return minioUtils.removeBucket(bucketName);
    }

    @Override
    public String getObjectUrl(String bucketName, String objectName) {
        return minioUtils.getObjectUrl(bucketName, objectName);
    }

    @Override
    public Iterable<Result<Item>> getObjectList(String bucketName) {
        Iterable<Result<Item>> results = minioUtils.listObjects(bucketName);
        return results;
    }
}
