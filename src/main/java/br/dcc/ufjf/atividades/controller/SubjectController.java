package br.dcc.ufjf.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import br.dcc.ufjf.atividades.controller_service.SubjectService;
import br.dcc.ufjf.atividades.model.Subject;

@Controller
// @RequestMapping("/subjects")
public class SubjectController{

    @Autowired
    private SubjectService subjectService;

    // @RequestMapping("/")
    // public String viewHomePage(){
    //     return "home";
    // }

    @RequestMapping("/subject")
        public String viewSubjectPage(Model model){
            List<Subject> listSubjects = subjectService.getSubjects();
            model.addAttribute("listSubjects", listSubjects); 
            return "subject";
        }
    

    @RequestMapping("/newSubj")
    public String showNewSubjetForm(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject",subject);
        return "newSubject";
    }

    @RequestMapping(value = "/savesubject", method=RequestMethod.POST)
        public String saveSubject(@ModelAttribute("subject") Subject subject){
            subjectService.saveSubject(subject);
            return "redirect:/subject";
        }
    

    @RequestMapping("/edits/{id}")
    public ModelAndView showEditSubjctForm(@PathVariable(name="id") Long id){
        ModelAndView  modelAndView= new ModelAndView("editSubject");
        
        Subject subject = subjectService.get(id);
        modelAndView.addObject("subject", subject);
        return modelAndView;
    }
    @RequestMapping("/deleteSubj/{id}")
    public String showDeleteSubjectForm(@PathVariable(name="id") Long id){
        subjectService.delete(id); 
        return "redirect:/subject";
    }

    // @Autowired
    // RepositoryStudent repositoryStudent;
    
    // @PostMapping
    // public Subject saveSubjects(@RequestBody Subject subjects){
    //   return repositorySubject.save(subjects);
    // }

    // @GetMapping
    // public List<Subject> getStudents(){
    //     return repositorySubject.findAll();
    // }
    // @PutMapping("/{subjectId}/student/{studentId}")
    // Subject enrolledStudentsToSubject(
    //     @PathVariable Long subjectId,
    //     @PathVariable Long studentId
    // ){
    //     Subject subject = repositorySubject.findById(subjectId).get();
    //     Student student = repositoryStudent.findById(studentId).get();
    //     subject.enrollStudent(student);
    //     return repositorySubject.save(subject);
        
    // }
} 