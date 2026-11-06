package com.acme.mini;

import java.io.File;
import java.nio.file.Files;

public class FileService {

  private static final String BASE_DIR = "/var/mini-app/uploads/";

  // CWE-22: Path Traversal — user-controlled filename concatenated into a file path
  public byte[] readUploadedFile(String filename) throws Exception {
    File file = new File(BASE_DIR + filename);
    return Files.readAllBytes(file.toPath());
  }

  // CWE-78: OS Command Injection — user input passed straight to a shell
  public String pingHost(String host) throws Exception {
    Process process = Runtime.getRuntime().exec("ping -c 1 " + host);
    return new String(process.getInputStream().readAllBytes());
  }
}
