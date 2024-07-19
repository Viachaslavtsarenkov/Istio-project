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
    public IdDto saveAudio(File file, String name) {
        AudioReqDto audioData = new AudioReqDto();
        audioData.setAudioFile(file);
        audioData.setTitle(name);
        return audioClient.sendAudio(audioData);
    }
}
