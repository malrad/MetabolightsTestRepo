package com.ebi.metabolights.study.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.ebi.metabolights.study.dto.AuthorDTO;

@Entity
@Table(name = "AUTHOR")
@EntityListeners(AuditingEntityListener.class)
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer authorId;
	@Column
	private String authorName;

	@Column
	private String authorEmail;
	
	
	
	@OneToMany(targetEntity=Study.class, mappedBy="author",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
	private List<Study> studies = new ArrayList<>();
	
	public Author(){
		
	}
	
	
	public Author(AuthorDTO auth){
		this.authorId=auth.getAuthorId();
		this.authorName=auth.getAuthorName();
		this.authorEmail=auth.getAuthorEmail();
	}

	
	public List<Study> getStudies() {
		return studies;
	}

	public void setStudies(List<Study> studies) {
		this.studies = studies;
	}

	public Integer getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorEmail() {
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}

	

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorEmail=" + authorEmail
				+  "]";
	}
}
