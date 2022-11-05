package com.yash.fileUpload.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.yash.fileUpload.model.FileUploadModel;
import com.yash.fileUpload.repository.FileUploadRepository;

@Service
public class FileUploadService {

  @Autowired
  private FileUploadRepository fileDBRepository;

  public FileUploadModel store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileUploadModel FileDB = new FileUploadModel(fileName, file.getContentType(), file.getBytes());

    return fileDBRepository.save(FileDB);
  }

  public FileUploadModel getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileUploadModel> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
}
