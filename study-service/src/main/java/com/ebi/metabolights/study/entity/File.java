package com.ebi.metabolights.study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebi.metabolights.study.dto.FileDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "STUDYFILE")
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fileId;

	@Column
	private String fileName;

	@Column
	private Long  fileSize;

	@Column
	private String filePath;
	
	@Column
	private Integer studyId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "studyId", referencedColumnName = "studyId", insertable = false, updatable = false)
	@JsonIgnore
	private Study study;
	
	public File() {}
	
	public File(FileDTO fileDto) {
		this.fileId=fileDto.getFileId();
		this.fileName=fileDto.getFileName();
		this.studyId=fileDto.getStudyId();
	}

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

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getStudyId() {
		return studyId;
	}

	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
	}

	public Study getStudy() {
		return study;
	}

	public void setStudy(Study study) {
		this.study = study;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "File [fileId=" + fileId + ", fileName=" + fileName + ", fileSize=\" + fileSize + \",studyId=" + studyId
				+ ", study=" + study + "]";
	}

}
