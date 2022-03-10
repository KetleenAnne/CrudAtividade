package br.dcc.ufjf.atividades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.dcc.ufjf.atividades.model.Activities;
import br.dcc.ufjf.atividades.repository.ActivitiesRepository;

@Service
public class ActivitiesService {
    
     @Autowired
     private ActivitiesRepository repositoryActivities;
         
    // lista todos os Activities
    
     public List<Activities> findAllActivities(){
         return repositoryActivities.findAll();
     }
        
    // // salva um novo Activities
     public Activities saveActivities(@RequestBody Activities activities){
             return repositoryActivities.save(activities);
     }
        
    // // procura um Activities a partir do seu id
     public Activities get(Long id){
         return repositoryActivities.findById(id).get();
     }
        
    // // deleta Activities a partir do seu id
     public void delete(Long id){ 
         repositoryActivities.deleteById(id);
     }

}
