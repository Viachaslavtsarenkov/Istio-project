package com.tsarankou.audioservice.client;

import java.io.IOException;

public interface FileStorageClient {
    void uploadResource(String key, byte[] content);
    byte[] downloadResource(String key) throws IOException;
}
