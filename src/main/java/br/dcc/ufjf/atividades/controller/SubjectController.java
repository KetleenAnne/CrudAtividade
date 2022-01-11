package br.dcc.ufjf.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.model.Subject;
import br.dcc.ufjf.atividades.repository.RepositoryStudent;
import br.dcc.ufjf.atividades.repository.RepositorySubject;

@RestController
@RequestMapping("/subjects")

public class SubjectController{

    @Autowired
    RepositorySubject repositorySubject;

    @Autowired
    RepositoryStudent repositoryStudent;
    
    @PostMapping
    public Subject saveSubjects(@RequestBody Subject subjects){
      return repositorySubject.save(subjects);
    }

    @GetMapping
    public List<Subject> getStudents(){
        return repositorySubject.findAll();
    }
    @PutMapping("/{subjectId}/student/{studentId}")
    Subject enrolledStudentsToSubject(
        @PathVariable Long subjectId,
        @PathVariable Long studentId
    ){
        Subject subject = repositorySubject.findById(subjectId).get();
        Student student = repositoryStudent.findById(studentId).get();
        subject.enrollStudent(student);
        return repositorySubject.save(subject);
        
    }
} 