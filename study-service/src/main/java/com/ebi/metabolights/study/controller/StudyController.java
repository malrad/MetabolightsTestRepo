package com.ebi.metabolights.study.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebi.metabolights.study.dto.StudyDTO;
import com.ebi.metabolights.study.entity.Study;
import com.ebi.metabolights.study.exception.ResourceNotFoundException;
import com.ebi.metabolights.study.exception.StudyExceptionResponse;
import com.ebi.metabolights.study.service.StudyService;

import io.swagger.annotations.ApiOperation;
/**
 * Study Controller to GET,PUT,POST and DELETE Study
 * @author Malar
 *
 */
@RestController
@RequestMapping("api")
public class StudyController {
	@Autowired
	StudyService studyService;
	
	@PostMapping("Study")
	@ApiOperation(value ="To save Study")
	public Study saveStudy(@RequestBody  StudyDTO studyDto) {
		Study study=new Study(studyDto);
		try {
		studyService.saveStudy(study);
		}catch(DataIntegrityViolationException  ex) {
			throw new StudyExceptionResponse("Cannot save study for nonexistent author.");
		}catch(Exception  ex) {
			throw new StudyExceptionResponse("Cannot save study.");
		}
		
		return study;
	}
	
	@GetMapping("Study")
	@ApiOperation(value ="To get list of Studies")
	public List<Study> getStudies() {
		
		return studyService.getStudies();
	}
	
	@DeleteMapping("Study/{id}")
	@ApiOperation(value = "To delete study")
	public String deleteFile(@PathVariable("id") Integer studyId) {
		studyService.deleteStudy(studyId);
		return "Deleted Successfully";
	}
	
	
	@PutMapping("/Study/{id}")
	public Study updateStudy(@PathVariable(value = "id") Integer studyId, @Valid @RequestBody StudyDTO studyDto) throws ResourceNotFoundException {

		Optional<Study> optional = Optional.ofNullable(studyService.findById(studyId).orElseThrow(() -> new ResourceNotFoundException("Resource Not Found for Author: "+studyId)));

		Study study = optional.get();
		study.setAuthorId(studyDto.getAuthorId());
		study.setStudyTitle(studyDto.getStudyTitle());
		study.setKeywords(studyDto.getKeywords());
		study.setPublications(studyDto.getPublications());
		study.setStudyAbstract(studyDto.getStudyAbstract());
		return studyService.saveStudy(study);
	}

}
