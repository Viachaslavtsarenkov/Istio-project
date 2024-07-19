package com.tsarankou.clientservice.service;

import com.tsarankou.clientservice.service.dto.IdDto;

import java.io.File;

public interface ClientService {
    IdDto saveAudio(File file, String name);
}
