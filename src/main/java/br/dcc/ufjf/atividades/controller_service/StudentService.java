package br.dcc.ufjf.atividades.controller_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.repository.RepositoryStudent;

@Service
public class StudentService {

    // cria o repository student
    @Autowired
    private RepositoryStudent repositoryStudent;
 
    // lista todos os students
    //@GetMapping
    public List<Student> getStudents(){
        return repositoryStudent.findAll();
    }

    // salva um novo student
    //@PostMapping
    public Student saveStudent(@RequestBody Student students){
       return repositoryStudent.save(students);

    }
    public void saveStudentTeste(@RequestBody Student student){
        repositoryStudent.save(student);
    }

    // procura um student a partir do seu id
    public Student get(Long id){
        return repositoryStudent.findById(id).get();
    }

    // deleta student a partir do seu id
    public void delete(Long id){ 
        repositoryStudent.deleteById(id);
    }
}
