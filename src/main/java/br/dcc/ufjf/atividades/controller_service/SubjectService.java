package br.dcc.ufjf.atividades.controller_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.dcc.ufjf.atividades.model.Subject;
import br.dcc.ufjf.atividades.repository.RepositorySubject;

@Service
public class SubjectService {
    
    // cria o repository Subject
    @Autowired
    private RepositorySubject repositorySubject;
 
    // lista todos os Subjects
    //@GetMapping
    public List<Subject> getSubjects(){
        return repositorySubject.findAll();
    }

    // salva um novo Subject
    //@PostMapping
    public Subject saveStudent(@RequestBody Subject subject){
       return repositorySubject.save(subject);

    }

    // procura um Subject a partir do seu id
    public Subject get(Long id){
        return repositorySubject.findById(id).get();
    }

    // deleta Subject a partir do seu id
    public void delete(Long id){ 
        repositorySubject.deleteById(id);
    }
    
}
