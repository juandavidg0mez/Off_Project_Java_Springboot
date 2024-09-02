package com.projectmain.project.infrastructure.repositories.surveys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectmain.project.domain.entity.Surveys;


public interface SurveysRepository extends JpaRepository<Surveys,Long>{

}
