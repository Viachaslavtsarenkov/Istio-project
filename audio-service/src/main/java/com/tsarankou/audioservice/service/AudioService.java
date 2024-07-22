package com.tsarankou.audioservice.service;

import com.tsarankou.audioservice.dto.AudioReqDto;
import com.tsarankou.audioservice.dto.IdDto;

import java.io.IOException;

public interface AudioService {
    IdDto saveAudioData(AudioReqDto audioData) throws IOException;
}
