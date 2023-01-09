package com.example.uad.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.*;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.*;


@Service
public class Handler {

    @Value("${yandex.bucket.name}")
    private String bucketName;

    private final S3Client s3Client;

    public Handler() throws UnknownHostException {
        s3Client = DependencyFactory.s3Client();
    }

    public String sendRequest(MultipartFile file) throws IOException {
        String key = UUID.randomUUID().toString();

        var response = s3Client.putObject(PutObjectRequest.builder().bucket(bucketName).key(key)
                        .build(),
                        RequestBody.fromInputStream(file.getInputStream(), file.getSize()));

        return key;
    }

    public ResponseInputStream<GetObjectResponse> getFile(String fileName){
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();
        return s3Client.getObject(getObjectRequest);
    }
}