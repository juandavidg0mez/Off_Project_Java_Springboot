package com.projectmain.project.infrastructure.repositories.surveys.Categories_Catalog;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.projectmain.project.domain.entity.categories_catalog;

public interface Categories_CatalogRepository extends JpaRepository<categories_catalog, Long> {
  @Query("SELECT c.name, s.name " +
           "FROM categories_catalog AS c " +
           "INNER JOIN surveys AS s ON c.id = s.id " +
           "WHERE c.id = ?1")
    List<Object[]> findCategoryAndSurveyNamesById(Long id);

}
