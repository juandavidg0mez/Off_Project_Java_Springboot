package com.projectmain.project.infrastructure.repositories.surveys;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.projectmain.project.application.ISurveysService;
import com.projectmain.project.domain.entity.Surveys;


@Service
public class SurveysAdapter implements ISurveysService{
    @Autowired
    private SurveysRepository surveysRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<Surveys> findAll() {

        return (List<Surveys>)surveysRepository.findAll();
    }

    @Override
    @Transactional
    public Surveys save(Surveys surveys) {
        return surveysRepository.save(surveys);
    }

    @Override
    @Transactional
    public Optional<Surveys> DeleteById(Long id) {
       Optional<Surveys> surveysOptional = surveysRepository.findById(id);
       surveysOptional.ifPresent(surveysDb -> {
        surveysRepository.delete(surveysDb);
       });
       // Esto me retorna el producto que se elimino
       return surveysOptional;
        
    }

    @Override
    @Transactional
    public Optional<Surveys> update(Long id, Surveys surveys) {
        // busca el objeto para tomar de ese nuevmente y actualizarlo  para ello utiliza el metodo IsPresent paara por esi decirlo creal un nuevo objeto y de ahi contruir uno nuevo y ese nuevo objeto Guardarlo.

        Optional<Surveys> surveysOptional = surveysRepository.findById(id);
        if(surveysOptional.isPresent()){
                Surveys surveysDB = surveysOptional.orElseThrow();
                // Contruccion de nuevo objeto
                surveysDB.setName(surveys.getName());
                surveysDB.setAudit(surveys.getAudit());
                surveysDB.setCompenenthtml(surveys.getCompenenthtml());
                surveysDB.setComponentreact(surveys.getComponentreact());
                surveysDB.setDescription(surveys.getDescription());

                return Optional.of(surveysRepository.save(surveysDB));

            }
        
            return surveysOptional;
    }


}
