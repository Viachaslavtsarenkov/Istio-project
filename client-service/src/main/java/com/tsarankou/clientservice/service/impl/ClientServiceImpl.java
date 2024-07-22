package com.tsarankou.clientservice.service.impl;

import com.tsarankou.clientservice.client.AudioClient;
import com.tsarankou.clientservice.service.dto.AudioReqDto;
import com.tsarankou.clientservice.service.dto.IdDto;
import com.tsarankou.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final AudioClient audioClient;

    @Override
    public IdDto saveAudio(byte[] audioFile, String name) {
        AudioReqDto audioData = new AudioReqDto();
        audioData.setAudioFile(audioFile);
        audioData.setTitle(name);
        return audioClient.sendAudio(audioData);
    }
}
