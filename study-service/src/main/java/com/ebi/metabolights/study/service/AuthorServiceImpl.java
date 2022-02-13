package com.ebi.metabolights.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.metabolights.study.entity.Author;
import com.ebi.metabolights.study.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

	@Override
	public List<Author> getAuthors() {
		return authorRepository.findAll();
	}

	@Override
	public void deleteAuthor(Integer authorId) {
		authorRepository.deleteById(authorId);
		;
	}

	@Override
	public Optional<Author> findById(Integer authorId) {
		return authorRepository.findById(authorId);
	}

}
