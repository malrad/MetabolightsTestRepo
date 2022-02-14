package com.ebi.metabolights.study.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ebi.metabolights.study.entity.File;
import com.ebi.metabolights.study.exception.StudyExceptionResponse;
import com.ebi.metabolights.study.repository.FileRepository;

@Service
public class FileUploadServiceImpl implements FileUploadService {

	@Value("${storage.location}")
	private String location;

	@Autowired
	private FileRepository fileRepository;

	@Override
	public File store(MultipartFile file, File fileOj) {
		try {
			if (file.isEmpty()) {
				throw new StudyExceptionResponse("Failed to store empty file.");
			}
			/*Path destinationFile = Paths.get(location).resolve(Paths.get(file.getOriginalFilename())).normalize()
					.toAbsolutePath();
			if (!destinationFile.getParent().equals(Paths.get(location).toAbsolutePath())) {
				// This is a security check
				throw new StudyExceptionResponse("Cannot store file outside current directory.");
			}*/
			
				//InputStream inputStream = file.getInputStream();
				//Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
				fileOj.setFileSize(file.getSize());
				fileOj.setFile(file.getBytes());
		}catch (IOException e) {
			throw new StudyExceptionResponse("Failed to store file.", e);
		}

		return fileRepository.save(fileOj);
	}

	@Override
	public List<File> getFiles() {
		return fileRepository.findAll();
	}

	@Override
	public void deleteFile(Long fileId) {
		fileRepository.deleteById(fileId);
	}

}
