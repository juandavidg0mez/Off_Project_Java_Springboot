package com.projectmain.project.infrastructure.controllores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projectmain.project.application.ICategories_Catalog;
import com.projectmain.project.application.ISurveysService;
import com.projectmain.project.domain.entity.Surveys;
import com.projectmain.project.domain.entity.categories_catalog;

@Controller
@RequestMapping("/adimPermisos/Categories")
public class Categories_CatalogController {

    @Autowired
    private ICategories_Catalog iCategories_Catalog;

    @Autowired
    private ISurveysService iSurveysService;

    @GetMapping
    public ResponseEntity<List<categories_catalog>> findAll() {
        List<categories_catalog> categories = iCategories_Catalog.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody categories_catalog Categories, BindingResult result) {
        if (result.hasFieldErrors()) {  
            return validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(iCategories_Catalog.save(Categories));

    }

    @PostMapping("/{categoryId}/Surveys/{surveyId}")
    public ResponseEntity<?> AddSurveysToCategories(@PathVariable Long surveyId, @PathVariable Long categoryId) {
        Optional<categories_catalog> CatalogOptional = iCategories_Catalog.findById(categoryId);
        Optional<Surveys> SurveysOp = iSurveysService.findById(surveyId);

        if (!SurveysOp.isPresent() || !CatalogOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Surveys surveys = SurveysOp.get();
        categories_catalog catalog = CatalogOptional.get();

        catalog.getSurveys().add(surveys);
        iCategories_Catalog.save(catalog);

        return ResponseEntity.ok(catalog);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<categories_catalog> CatalogOptional = iCategories_Catalog.findById(id);
        if (CatalogOptional.isPresent()) {
            return ResponseEntity.ok(CatalogOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/adimPermisos/{id}")
    public ResponseEntity<?>  update(@RequestBody categories_catalog Categories , BindingResult result, @PathVariable Long id ){
        if (result.hasFieldErrors()) {
            return validation(result);
            
        }
        Optional<categories_catalog> CatalogOptional = iCategories_Catalog.update(id, Categories);
        if (CatalogOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(CatalogOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/Query/{categoryId}")
    public ResponseEntity<List<Object[]>> encontrarQuery(@PathVariable Long categoryId){
        List<Object[]> results = iCategories_Catalog.getCategoryAndSurveyNames(categoryId);
    
    if (results.isEmpty()) {
        return ResponseEntity.noContent().build(); // Retorna 204 si no hay resultados
    }
    
    return ResponseEntity.ok(results); 
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

    

}
