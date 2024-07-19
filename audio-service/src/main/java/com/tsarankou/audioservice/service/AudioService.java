package com.tsarankou.audioservice.service;

import com.tsarankou.audioservice.dto.AudioReqDto;
import com.tsarankou.audioservice.dto.IdDto;

public interface AudioService {
    IdDto saveAudioData(AudioReqDto audioData);
}
