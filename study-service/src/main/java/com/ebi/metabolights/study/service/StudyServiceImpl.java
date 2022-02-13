package com.ebi.metabolights.study.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebi.metabolights.study.entity.Study;
import com.ebi.metabolights.study.repository.StudyRepository;

@Service
public class StudyServiceImpl implements StudyService {

	@Autowired
	StudyRepository studyRepository;

	public Study saveStudy(Study study) {
		return studyRepository.save(study);
	}

	@Override
	public List<Study> getStudies() {
		return studyRepository.findAll();
	}

	@Override
	public void deleteStudy(Integer studyId) {
		studyRepository.deleteById(studyId);
	}

	@Override
	public Optional<Study> findById(Integer studyId) {
		return studyRepository.findById(studyId);
	}

}
