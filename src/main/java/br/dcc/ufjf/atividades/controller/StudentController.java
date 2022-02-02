package br.dcc.ufjf.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.dcc.ufjf.atividades.controller_service.StudentService;
import br.dcc.ufjf.atividades.controller_service.SubjectService;
import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.model.Subject;

//@RestController
//@RequestMapping("/student")
@Controller
public class StudentController{
    
    @Autowired
    private  StudentService studentService;

    // @Autowired
    // private SubjectService subjectService;
    
    // private Subject subject1 = new Subject("1234", "Calculo");
    // subjectService.saveSubjectTeste(new Subject("1234", "Calculo"));

    // private Student student1 = new Student("Leandro", "123.456.789-70", "12/10/2000");


    @RequestMapping("/")
    public String viewHomePage(){
        return "home";
    }
    

    @RequestMapping("/student")
    public String viewStudentPage(Model model){

        List<Student> listStudents = studentService.getStudents();
        model.addAttribute("listStudents", listStudents); 
        return "student";

    }

    @RequestMapping("/new")
    public String showNewStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "newStudent";
    }

    @RequestMapping(value = "/save", method=RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/student";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentForm(@PathVariable(name="id") Long id){
        ModelAndView  modelAndView= new ModelAndView("editStudent");
        
        Student student = studentService.get(id);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public String showDeleteStudentForm(@PathVariable(name="id") Long id){
        studentService.delete(id); 
        return "redirect:/student";
    }

    @RequestMapping("/viewSubjects/{id}")
    public ModelAndView showViewSubjectsForm (@PathVariable(name="id") Long id){
        ModelAndView  modelAndView= new ModelAndView("viewSubjectsId");

        Student student = studentService.get(id);
        // student.getSubjects().add(new Subject("2146","calculo"));
        modelAndView.addObject("student", student);
        return modelAndView;
    }/*criar o html disso e usar a ideia do /save para o set das listas de materias dos estudantes */

}