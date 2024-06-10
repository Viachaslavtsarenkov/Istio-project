package com.tsarankou.clientservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("client.audio")
public class AudioClientProperties {
    private String id;
    private String endpoint;
}
