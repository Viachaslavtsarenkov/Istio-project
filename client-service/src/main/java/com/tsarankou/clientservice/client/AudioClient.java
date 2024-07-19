package com.tsarankou.clientservice.client;

import com.tsarankou.clientservice.service.dto.AudioReqDto;
import com.tsarankou.clientservice.service.dto.IdDto;

public interface AudioClient {
    IdDto sendAudio(AudioReqDto audioReqDto);
}
