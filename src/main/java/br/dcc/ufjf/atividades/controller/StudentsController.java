package br.dcc.ufjf.atividades.controller;

import java.util.*;
import br.dcc.ufjf.atividades.model.*;
import br.dcc.ufjf.atividades.repository.RepositoryStudents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")

public class StudentsController{
    @Autowired
    RepositoryStudents repositoryStudents;
    
    @PostMapping
    public Student saveStudent(@RequestBody Student students){
       return repositoryStudents.save(students);

    }
    @GetMapping
    public List<Student> getStudents(){
        return repositoryStudents.findAll();
    }
}