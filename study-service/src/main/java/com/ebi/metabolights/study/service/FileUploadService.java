package com.ebi.metabolights.study.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ebi.metabolights.study.entity.File;

public interface FileUploadService {
	
	File store(MultipartFile file,File fileDto);
	List<File> getFiles();
	void deleteFile(Long fileId);

}
