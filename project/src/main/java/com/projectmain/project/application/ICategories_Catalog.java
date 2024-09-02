package com.projectmain.project.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projectmain.project.domain.entity.categories_catalog;

@Service
public interface ICategories_Catalog {
    List<categories_catalog> findAll();
    categories_catalog save(categories_catalog CategoriaSurveys);
    Optional<categories_catalog>  update(Long id,categories_catalog CategoriaSurveys);
    Optional<categories_catalog> deleteById(Long id);
}
