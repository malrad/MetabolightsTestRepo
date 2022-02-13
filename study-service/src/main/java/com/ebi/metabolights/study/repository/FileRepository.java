package com.ebi.metabolights.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebi.metabolights.study.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long>{

}
