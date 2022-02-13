package com.ebi.metabolights.study.dto;

import java.util.List;

public class StudyDTO {
	private Integer studyId;
	private String studyTitle;
	private Integer authorId;
	private String studyAbstract;
	private List<String> keywords;
	private List<String> publications;
	public Integer getStudyId() {
		return studyId;
	}
	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
	}
	public String getStudyTitle() {
		return studyTitle;
	}
	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getStudyAbstract() {
		return studyAbstract;
	}
	public void setStudyAbstract(String studyAbstract) {
		this.studyAbstract = studyAbstract;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public List<String> getPublications() {
		return publications;
	}
	public void setPublications(List<String> publications) {
		this.publications = publications;
	}

}
