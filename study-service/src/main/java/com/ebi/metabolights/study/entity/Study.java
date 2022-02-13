package com.ebi.metabolights.study.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ebi.metabolights.study.dto.StudyDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Study")
public class Study {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer studyId;

	@Column
	private String studyTitle;

	@Column
	private Integer authorId;

	@Column
	private String studyAbstract;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "authorId", referencedColumnName = "authorId", insertable = false, updatable = false)
	@JsonIgnore
	private Author author;

	@OneToMany(targetEntity = File.class, mappedBy = "study", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<File> files = new ArrayList<>();

	@ElementCollection
	private List<String> keywords;

	@ElementCollection
	private List<String> publications;
	
	public Study() {}
	
	
	public Study(StudyDTO studyDto) {
		this.studyId=studyDto.getStudyId();
		this.studyTitle=studyDto.getStudyTitle();
		this.studyAbstract=studyDto.getStudyAbstract();
		this.keywords=studyDto.getKeywords();
		this.publications=studyDto.getPublications();
		this.authorId=studyDto.getAuthorId();
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getStudyTitle() {
		return studyTitle;
	}

	public void setStudyTitle(String studyTitle) {
		this.studyTitle = studyTitle;
	}

	public Integer getStudyId() {
		return studyId;
	}

	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
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

	public void setPublications(List<String> publicatios) {
		this.publications = publicatios;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Override
	public String toString() {
		return "Study [studyId=" + studyId + ", studyTitle=" + studyTitle + ", studyAbstract=" + studyAbstract
				+ ", keywords=" + keywords + ", publications=" + publications + "]";
	}

}
