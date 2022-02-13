package com.ebi.metabolights.study.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FileDTO {
	
	private Integer fileId;
	private String fileName;
	private List<MultipartFile> fileList;
	private Integer studyId;

	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getStudyId() {
		return studyId;
	}
	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
	}
	public List<MultipartFile> getFileList() {
		return fileList;
	}
	public void setFileList(List<MultipartFile> fileList) {
		this.fileList = fileList;
	}	
	
}
