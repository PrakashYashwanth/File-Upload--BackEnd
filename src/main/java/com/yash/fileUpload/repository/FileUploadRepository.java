package com.yash.fileUpload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.fileUpload.model.FileUploadModel;
@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadModel, String> {

}