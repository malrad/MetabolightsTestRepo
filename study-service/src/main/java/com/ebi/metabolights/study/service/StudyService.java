package com.ebi.metabolights.study.service;

import java.util.List;
import java.util.Optional;

import com.ebi.metabolights.study.entity.Study;

public interface StudyService {
	
	public Study saveStudy(Study study);
	List<Study> getStudies();
	void deleteStudy(Integer studyId);
	Optional<Study> findById(Integer studyId);

}
