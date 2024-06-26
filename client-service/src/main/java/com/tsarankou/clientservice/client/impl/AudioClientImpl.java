package com.tsarankou.clientservice.client.impl;

import com.tsarankou.clientservice.client.AudioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
@RequiredArgsConstructor
@Slf4j
public class AudioClientImpl implements AudioClient {
    private final WebClient webClient;

    @Override
    public void saveAudio() {

    }
}
