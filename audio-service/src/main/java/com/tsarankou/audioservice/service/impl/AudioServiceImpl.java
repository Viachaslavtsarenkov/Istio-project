package com.tsarankou.audioservice.service.impl;

import com.tsarankou.audioservice.client.FileStorageClient;
import com.tsarankou.audioservice.data.entity.Audio;
import com.tsarankou.audioservice.data.entity.AudioRepository;
import com.tsarankou.audioservice.service.AudioService;
import com.tsarankou.audioservice.dto.AudioReqDto;
import com.tsarankou.audioservice.dto.IdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class AudioServiceImpl implements AudioService {

    private final AudioRepository audioRepository;
    private final FileStorageClient fileStorageClient;
    @Override
    @Transactional
    public IdDto saveAudioData(AudioReqDto audioData) throws IOException {

        String randomKey = UUID.randomUUID().toString();
        fileStorageClient.uploadResource(randomKey, audioData.getAudioFile());

        Audio audio = new Audio();
        audio.setTitle(audioData.getTitle());
        audio.setLink(randomKey);
        audioRepository.save(audio);

        log.info("Audio saved with id:{}", audio.getId());
        IdDto response = new IdDto();
        response.setId(audio.getId());
        return response;
    }
}
