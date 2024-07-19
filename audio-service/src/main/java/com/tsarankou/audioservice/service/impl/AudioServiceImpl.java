package com.tsarankou.audioservice.service.impl;

import com.tsarankou.audioservice.data.entity.Audio;
import com.tsarankou.audioservice.data.entity.AudioRepository;
import com.tsarankou.audioservice.service.AudioService;
import com.tsarankou.audioservice.dto.AudioReqDto;
import com.tsarankou.audioservice.dto.IdDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AudioServiceImpl implements AudioService {

    private final AudioRepository audioRepository;
    @Override
    public IdDto saveAudioData(AudioReqDto audioData) {
        Audio audio = new Audio();
        audio.setTitle(audioData.getTitle());
        audioRepository.save(audio);
        log.info("Audio saved with id:{}", audio.getId());
        IdDto response = new IdDto();
        response.setId(audio.getId());
        return response;
    }
}
