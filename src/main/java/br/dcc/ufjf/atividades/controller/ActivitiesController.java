package br.dcc.ufjf.atividades.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.dcc.ufjf.atividades.controller_service.ActivitiesService;
import br.dcc.ufjf.atividades.controller_service.StudentService;
import br.dcc.ufjf.atividades.controller_service.SubjectService;
import br.dcc.ufjf.atividades.model.Activities;
import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.model.Subject;

@Controller
public class ActivitiesController {

    @Autowired
    ActivitiesService activitiesService;

    @Autowired
    StudentService studentService;
    
    @Autowired
    SubjectService subjectService;

    @RequestMapping("/")
    public String viewHomePage(Model model){

        Activities activities = new Activities();
        model.addAttribute("activities", activities); 

        List<Student> listStudents = studentService.getStudents();
        model.addAttribute("listStudents", listStudents);

        List<Subject> listSubjects = subjectService.getSubjects();
        model.addAttribute("listSubjects", listSubjects);

        return "home";
    }

    // @RequestMapping(value="/saveActivities", method = RequestMethod.POST)
    // public String saveActivities(@ModelAttribute("activities")Activities activities){
    //     activitiesService.saveActivities(activities);
    //     return "redirect:/";
    // }
   
    // @RequestMapping(value="/saveActivities", method = RequestMethod.POST)

    
    
}
