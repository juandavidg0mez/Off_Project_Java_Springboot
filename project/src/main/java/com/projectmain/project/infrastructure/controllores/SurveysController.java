package com.projectmain.project.infrastructure.controllores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectmain.project.application.ISurveysService;
import com.projectmain.project.domain.entity.Surveys;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/adimPermisos/Surveys")
public class SurveysController {
    @Autowired
    private ISurveysService iSurveysService;

    @GetMapping
    public List<Surveys> findAll(){
        return iSurveysService.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Surveys surveys, BindingResult result){
        if (result.hasFieldErrors()) {
            return validation(result);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(iSurveysService.save(surveys));
    
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Surveys> surOptional = iSurveysService.DeleteById(id);
        if(surOptional.isPresent()){
            return ResponseEntity.ok(surOptional.orElseThrow());


        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Surveys surveys, BindingResult result, @PathVariable Long id){
        if(result.hasFieldErrors()){
            return validation(result);
        }
        Optional<Surveys> sOptional = iSurveysService.update(id, surveys);
        if(sOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(sOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


     private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
