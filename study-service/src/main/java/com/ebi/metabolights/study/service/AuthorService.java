package com.ebi.metabolights.study.service;

import java.util.List;
import java.util.Optional;

import com.ebi.metabolights.study.entity.Author;

public interface AuthorService {
	
	Author saveAuthor(Author authors);
	List<Author> getAuthors();
	void deleteAuthor(Integer authorId);
	Optional<Author> findById(Integer authorId);
}
