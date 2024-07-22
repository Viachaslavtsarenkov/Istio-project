package com.tsarankou.audioservice.client.impl;

import com.tsarankou.audioservice.client.FileStorageClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketResponse;
import software.amazon.awssdk.services.s3.model.NoSuchBucketException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.waiters.S3Waiter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class FileStorageClientImpl implements FileStorageClient {

    @Value("${client.audio.s3.bucket}")
    private String bucket;
    private final S3Client s3Client;
    @Override
    public void uploadResource(String key, byte[] content) {
        if (!bucketExists(bucket)) {
            createBucket(bucket);
        }
        PutObjectRequest request = PutObjectRequest.builder().bucket(bucket).key(key).build();
        s3Client.putObject(request, RequestBody.fromBytes(content));
        log.info("Uploaded to S3: {}, length: {}", key, content.length);
    }

    @Override
    public byte[] downloadResource(String key) throws IOException {
        return new byte[0];
    }

    private boolean bucketExists(String bucketName) {
        HeadBucketRequest request = HeadBucketRequest
                .builder()
                .bucket(bucketName)
                .build();
        try {
            s3Client.headBucket(request);
            return true;
        } catch (NoSuchBucketException e) {
            return false;
        }
    }

    private void createBucket(String bucketName) {
        log.info("Creating S3 bucket: '{}'", bucketName);
        CreateBucketRequest bucketRequest = CreateBucketRequest.builder()
                .bucket(bucketName)
                .build();

        s3Client.createBucket(bucketRequest);

        S3Waiter s3Waiter = s3Client.waiter();
        HeadBucketRequest bucketRequestWait = HeadBucketRequest.builder()
                .bucket(bucketName)
                .build();

        WaiterResponse<HeadBucketResponse> waiterResponse = s3Waiter.waitUntilBucketExists(bucketRequestWait);
        waiterResponse.matched().response().map(Object::toString).ifPresent(log::info);
        log.info("Created S3 bucket: '{}'", bucketName);
    }
}
