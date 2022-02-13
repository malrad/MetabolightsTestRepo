package com.ebi.metabolights.study.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.metabolights.study.dto.AuthorDTO;
import com.ebi.metabolights.study.entity.Author;
import com.ebi.metabolights.study.exception.ResourceNotFoundException;
import com.ebi.metabolights.study.service.AuthorService;

import io.swagger.annotations.ApiOperation;

/**
 * Author Controller to GET,PUT,POST and DELETE Author
 * @author Malar
 *
 */
@RestController
@RequestMapping("api")
public class AuthorController {
	
	@Autowired
	AuthorService  authorService;
    
	@GetMapping("Author")
	@ApiOperation(value ="To get list of Authors")
	public List<Author> getAuthors() {
		
		return authorService.getAuthors();
	}
	
	@PostMapping("Author")
	@ApiOperation(value ="To save Author")
    public Author saveAuthor(
    		@Valid @RequestBody AuthorDTO author)
    {
		Author auth=new Author(author);
        return authorService.saveAuthor(auth);
    }
	
	@DeleteMapping("Author/{id}")
	@ApiOperation(value ="To delete Author")
    public String deleteAuthor(
    		@PathVariable("id") Integer authorId)
    {
		authorService.deleteAuthor(authorId);
        return "Deleted Successfully";
    }
	
	
	@PutMapping("/Author/{id}")
	@ApiOperation(value ="To update Author")
	public Author updateNote(@PathVariable(value = "id") Integer authorId, @Valid @RequestBody AuthorDTO authorDto) throws ResourceNotFoundException {
		
		Optional<Author> optional = authorService.findById(authorId);
		if(null==optional) {
			throw new ResourceNotFoundException("Author not found for authorId: "+ authorId);
		}
		
		Author auth = optional.get();
		auth.setAuthorEmail(authorDto.getAuthorEmail());
		auth.setAuthorName(authorDto.getAuthorName());

		return authorService.saveAuthor(auth);
	}
	      
}
