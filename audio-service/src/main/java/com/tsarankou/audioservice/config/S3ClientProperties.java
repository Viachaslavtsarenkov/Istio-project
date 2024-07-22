package com.tsarankou.audioservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("client.audio.s3")
public class S3ClientProperties {
    private String url;
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String region;
}
