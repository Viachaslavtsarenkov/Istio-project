package com.tsarankou.clientservice.service.dto;


import lombok.Data;
import java.io.File;

@Data
public class AudioReqDto {
    private byte[] audioFile;
    private String title;
}
