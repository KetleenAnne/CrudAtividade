package br.dcc.ufjf.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dcc.ufjf.atividades.controller_service.StudentService;
import br.dcc.ufjf.atividades.model.Student;

//@RestController
//@RequestMapping("/student")
@Controller
public class StudentController{
    
    @Autowired
    private  StudentService studentService;

    @RequestMapping("/")
    public String viewHomePage(Model model){

        List<Student> listStudents = studentService.getStudents();
        model.addAttribute("listStudents", listStudents); 
        return "index";

    }
  
}