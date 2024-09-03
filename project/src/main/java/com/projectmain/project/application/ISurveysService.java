package com.projectmain.project.application;

import java.util.List;
import java.util.Optional;

import com.projectmain.project.domain.entity.Surveys;

public interface ISurveysService {
    List<Surveys> findAll();
    Optional<Surveys> findById(Long id);
    Surveys save(Surveys surveys);
    Optional<Surveys> DeleteById(Long id);
    Optional<Surveys> update(Long id, Surveys surveys);
}
