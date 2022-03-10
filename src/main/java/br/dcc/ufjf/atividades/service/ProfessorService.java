package br.dcc.ufjf.atividades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.dcc.ufjf.atividades.model.Professor;
import br.dcc.ufjf.atividades.repository.ProfessorRepository;

@Service
public class ProfessorService {
        // cria o repository Professor
        @Autowired
        private ProfessorRepository repositoryProfessor;
     
        // lista todos os Professores
        //@GetMapping
        public List<Professor> findAllProfessors(){
            return repositoryProfessor.findAll();
        }
    
        // salva um novo Professsor
        public Professor saveProfessor(@RequestBody Professor professor){
           return repositoryProfessor.save(professor);
    
        }
    
        // procura um Professor a partir do seu id
        public Professor get(Long id){
            return repositoryProfessor.findById(id).get();
        }
    
        // deleta Professor a partir do seu id
        public void delete(Long id){ 
            repositoryProfessor.deleteById(id);
        }
}
