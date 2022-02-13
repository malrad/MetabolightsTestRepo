package com.ebi.metabolights.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ebi.metabolights.study.dto.FileDTO;
import com.ebi.metabolights.study.entity.File;
import com.ebi.metabolights.study.exception.StudyExceptionResponse;
import com.ebi.metabolights.study.service.FileUploadService;

import io.swagger.annotations.ApiOperation;

/**
 * File Controller to GET,POST Files
 * @author Malar
 *
 */
@RestController
@RequestMapping("api")
public class FileUploadController {

	@Autowired
	FileUploadService fileUploadService;

	@PostMapping(path = "/fileUpload", consumes = { "multipart/form-data" })
	@ApiOperation(value = "files")
	public String handleFileUpload(@RequestPart List<MultipartFile> fileList, FileDTO fileDto) {
		try {
		File files = new File(fileDto);
		fileList.parallelStream().forEach(file   ->fileUploadService.store(file, files));
		}catch(DataIntegrityViolationException  ex) {
			throw new StudyExceptionResponse("Cannot save file for nonexistent study.");
		}catch(Exception  ex) {
			throw new StudyExceptionResponse("Cannot store file.");
		}
		return "redirect:/";
	}

	@GetMapping("StudyFiles")
	@ApiOperation(value = "To get list of Files")
	public List<File> getFiles() {

		return fileUploadService.getFiles();
	}

	/*
	 * @DeleteMapping("Files/{id}")
	 * 
	 * @ApiOperation(value = "To delete File") public String
	 * deleteFile(@PathVariable("id") Long fileId) {
	 * fileUploadService.deleteFile(fileId); return "Deleted Successfully"; }
	 */
}
