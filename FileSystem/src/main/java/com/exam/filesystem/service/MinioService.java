package com.exam.filesystem.service;

import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface MinioService {

    String uploadFile(MultipartFile multipartFile, String bucketName);

    Boolean bucketExist(String bucketName);

    InputStream downLoadFile(String bucketName, String objectName);

    Boolean removeFile(String bucketName, String objectName);

    Boolean removeBucket(String bucketName);

    String getObjectUrl(String bucketName, String objectName);

    Iterable<Result<Item>> getObjectList(String bucketName);
}
