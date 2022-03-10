package br.dcc.ufjf.atividades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.dcc.ufjf.atividades.model.Subject;
import br.dcc.ufjf.atividades.repository.SubjectRepository;

@Service
public class SubjectService {
    
    // cria o repository Subject
    @Autowired
    private SubjectRepository repositorySubject;
 
    // lista todos os Subjects
    //@GetMapping
    public List<Subject> findAllSubjects(){
        return repositorySubject.findAll();
    }

    // salva um novo Subject
    //@PostMapping
    public Subject saveSubject(@RequestBody Subject subject){
       return repositorySubject.save(subject);

    }
    @PostMapping
    public void saveSubjectTeste( Subject subject){
        repositorySubject.save(subject);
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
