package com.tsarankou.audioservice.dto;

import lombok.Data;

import java.io.File;

@Data
public class AudioReqDto {
    private File audioFile;
    private String title;
}