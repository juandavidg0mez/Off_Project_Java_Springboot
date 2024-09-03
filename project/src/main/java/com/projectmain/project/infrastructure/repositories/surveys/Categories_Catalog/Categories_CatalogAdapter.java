package com.projectmain.project.infrastructure.repositories.surveys.Categories_Catalog;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmain.project.application.ICategories_Catalog;
import com.projectmain.project.domain.entity.categories_catalog;

import org.springframework.transaction.annotation.Transactional;

@Service
public class Categories_CatalogAdapter implements ICategories_Catalog{
    @Autowired
    private Categories_CatalogRepository catalogRepository;

    @Transactional(readOnly = true)
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
        
        Optional<categories_catalog> CategoriaSurveysOptional = catalogRepository.findById(id);
        if (CategoriaSurveysOptional.isPresent()) {
            catalogRepository.deleteById(id);
            return CategoriaSurveysOptional;
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<categories_catalog> findById(Long id) {
        Optional<categories_catalog> CatalogOptional = catalogRepository.findById(id);
        CatalogOptional.ifPresent(CatalogDB ->{
            catalogRepository.findById(id);
        });
        return CatalogOptional;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Object[]> getCategoryAndSurveyNames(Long id) {
        return catalogRepository.findCategoryAndSurveyNamesById(id);
    }
        

}
