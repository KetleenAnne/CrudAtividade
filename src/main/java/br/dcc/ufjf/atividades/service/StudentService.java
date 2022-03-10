package br.dcc.ufjf.atividades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.repository.StudentRepository;

@Service
public class StudentService {

    // cria o repository student
    @Autowired
    private StudentRepository repositoryStudent;
 
    // lista todos os students
    //@GetMapping
    public List<Student> findAllStudents(){
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
