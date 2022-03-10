package br.dcc.ufjf.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.dcc.ufjf.atividades.model.Registration;
import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.model.Subject;
import br.dcc.ufjf.atividades.service.RegistrationService;
import br.dcc.ufjf.atividades.service.StudentService;
import br.dcc.ufjf.atividades.service.SubjectService;

@Controller
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    StudentService studentService;

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value="/saveRegistration", method = RequestMethod.POST)
    public String saveRegistration(@ModelAttribute("registration")Registration registration){
        registrationService.saveRegistration(registration);
        return "redirect:/registration";
    }

    @RequestMapping("/registration")
    public String viewRegistrationPage(Model model){

        Registration registration = new Registration();
        model.addAttribute("registration", registration); 

        List<Registration> listRegistrations = registrationService.findAllRegistrations();
        model.addAttribute("listRegistrations", listRegistrations);

        List<Student> listStudents = studentService.findAllStudents();
        model.addAttribute("listStudents", listStudents);

        List<Subject> listSubjects = subjectService.findAllSubjects();
        model.addAttribute("listSubjects", listSubjects);

        return "registration";
    }
   
}
