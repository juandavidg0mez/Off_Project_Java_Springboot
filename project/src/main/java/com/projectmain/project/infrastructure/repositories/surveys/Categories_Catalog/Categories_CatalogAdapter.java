package com.projectmain.project.infrastructure.repositories.surveys.Categories_Catalog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.projectmain.project.application.ICategories_Catalog;
import com.projectmain.project.domain.entity.categories_catalog;

import jakarta.transaction.Transactional;

public class Categories_CatalogAdapter implements ICategories_Catalog{
    @Autowired
    private Categories_CatalogRepository catalogRepository;

    @Transactional
    @Override
    public List<categories_catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Transactional
    @Override
    public categories_catalog save(categories_catalog CategoriaSurveys) {
        return catalogRepository.save(CategoriaSurveys);
    }
    @Transactional
    @Override
    public Optional<categories_catalog> update(Long id, categories_catalog CategoriaSurveys) {
        Optional<categories_catalog> cOptional = catalogRepository.findById(id);
        if(cOptional.isPresent()){
            categories_catalog CatalogBD = cOptional.orElseThrow();
            CatalogBD.setName(CategoriaSurveys.getName());
            return Optional.of(catalogRepository.save(CatalogBD));
        }

        return cOptional;
        
    }
    @Transactional
    @Override
    public Optional<categories_catalog> deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
