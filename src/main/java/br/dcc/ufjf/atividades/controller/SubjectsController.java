package br.dcc.ufjf.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.model.Subject;
import br.dcc.ufjf.atividades.repository.RepositoryStudents;
import br.dcc.ufjf.atividades.repository.RepositorySubjects;

@RestController
@RequestMapping("/subjects")

public class SubjectsController{

    @Autowired
    RepositorySubjects repositorySubjects;

    @Autowired
    RepositoryStudents repositoryStudents;
    
    @PostMapping
    public Subject saveSubjects(@RequestBody Subject subjects){
      return repositorySubjects.save(subjects);
    }

    @GetMapping
    public List<Subject> getStudents(){
        return repositorySubjects.findAll();
    }
    @PutMapping("/{subjectId}/student/{studentId}")
    Subject enrolledStudentsToSubject(
        @PathVariable int subjectId,
        @PathVariable int studentId
    ){
        Subject subject = repositorySubjects.findById(subjectId).get();
        Student student = repositoryStudents.findById(studentId).get();
        subject.enrollStudent(student);
        return repositorySubjects.save(subject);
        
    }
} 