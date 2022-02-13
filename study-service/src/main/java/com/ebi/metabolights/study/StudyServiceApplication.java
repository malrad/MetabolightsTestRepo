package com.ebi.metabolights.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Study Service Application
 * @author Malar
 *
 */
@SpringBootApplication
@EnableJpaAuditing
public class StudyServiceApplication 
{
    public static void main( String[] args )
    {
       SpringApplication.run(StudyServiceApplication.class,args);
    }
}
