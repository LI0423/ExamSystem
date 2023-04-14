package com.exam.filesystem.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface MinioService {

    String uploadFile(MultipartFile multipartFile, String bucketName);

    Boolean bucketExist(String bucketName);

    InputStream downLoadFile(String bucketName, String objectName);

    Boolean removeFile(String bucketName, String objectName);

    Boolean removeBucket(String bucketName);

    String getObjectUrl(String bucketName, String objectName);
}
