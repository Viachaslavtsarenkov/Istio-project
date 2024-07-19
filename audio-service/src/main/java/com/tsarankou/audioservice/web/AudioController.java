package com.tsarankou.audioservice.web;

import com.tsarankou.audioservice.dto.AudioReqDto;
import com.tsarankou.audioservice.dto.IdDto;
import com.tsarankou.audioservice.service.AudioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/audio")
@RequiredArgsConstructor
public class AudioController {

    private final AudioService audioService;
    @PostMapping
    public IdDto saveAudio(@RequestBody AudioReqDto requestData) {
        return audioService.saveAudioData(requestData);
    }

}
