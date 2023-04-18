package com.exam.filesystem.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private static final long serialVersionUID = 1L;

    private String endpoint;

    private Integer port;

    private String accessKey;

    private String secretKey;

    private Boolean secure;

    private String bucketName;

    private Integer imageSize;

    private Integer fileSize;

    @Bean
    public MinioClient MinioClientProperties(){
        MinioClient minioClient = MinioClient.builder().credentials(accessKey, secretKey).endpoint(endpoint, port, secure).build();
        return minioClient;
    }

}
