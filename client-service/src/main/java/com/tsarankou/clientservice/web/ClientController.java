package com.tsarankou.clientservice.web;

import com.tsarankou.clientservice.service.ClientService;
import com.tsarankou.clientservice.service.dto.IdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/client/audio")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;
    @PostMapping
    public IdDto saveAudioFile(@RequestParam(name = "audioFile") MultipartFile audioFile,
                               @RequestParam(name = "title") String title) throws IOException {
        //todo
        // get file and set it into request

        File convFile = new File( audioFile.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write(audioFile.getBytes());
        fos.close();

        return clientService.saveAudio(convFile,title);
    }
}
