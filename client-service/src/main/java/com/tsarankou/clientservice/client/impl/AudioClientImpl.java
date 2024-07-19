package com.tsarankou.clientservice.client.impl;

import com.tsarankou.clientservice.client.AudioClient;
import com.tsarankou.clientservice.config.AudioClientProperties;
import com.tsarankou.clientservice.service.dto.AudioReqDto;
import com.tsarankou.clientservice.service.dto.IdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class AudioClientImpl implements AudioClient {

    private final WebClient webClient;
    private final AudioClientProperties audioClientConfig;

    @Override
    public IdDto sendAudio(AudioReqDto audioReqDto) {
        log.info("Send request to AUDIO");

        IdDto response = webClient.post()
                .uri(audioClientConfig.getId() + audioClientConfig.getEndpoint())
                .bodyValue(audioReqDto)
                .retrieve()
                .bodyToMono(IdDto.class)
                .block();

        log.info("Received response from AUDIO: {}", response);
        return response;
    }


}
