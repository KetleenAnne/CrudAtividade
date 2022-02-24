package br.dcc.ufjf.atividades.controller_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody; 

import br.dcc.ufjf.atividades.model.Registration;
import br.dcc.ufjf.atividades.repository.RegistrationRepository;

@Service
public class RegistrationService {

    // cria o repository Registration
    @Autowired
    private RegistrationRepository repositorRegistration;
 
    // lista todos os Registration
    //@GetMapping
    public List<Registration> getRegistrations(){
        return repositorRegistration.findAll();
    }

    // salva um novo Registration
    //@PostMapping
    public Registration saveRegistration(@RequestBody Registration registration){
       return repositorRegistration.save(registration);

    }
    public void saveRegistrationtTeste(@RequestBody Registration registration){
        repositorRegistration.save(registration);
    }

    // procura um Registration a partir do seu id
    public Registration get(Long id){
        return repositorRegistration.findById(id).get();
    }

    // deleta Registration a partir do seu id
    public void delete(Long id){ 
        repositorRegistration.deleteById(id);
    }
}


