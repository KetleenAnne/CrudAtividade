package br.dcc.ufjf.atividades.controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.dcc.ufjf.atividades.model.Activities;
import br.dcc.ufjf.atividades.model.Document;
import br.dcc.ufjf.atividades.model.Student;
import br.dcc.ufjf.atividades.model.Subject;
import br.dcc.ufjf.atividades.service.ActivitiesService;
import br.dcc.ufjf.atividades.service.DocumentService;
import br.dcc.ufjf.atividades.service.StudentService;
import br.dcc.ufjf.atividades.service.SubjectService;

@Controller
public class ActivitiesController {

    @Autowired
    private DocumentService documentService;

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

         List<Student> listStudents = studentService.findAllStudents();
         model.addAttribute("listStudents", listStudents);

         List<Subject> listSubjects = subjectService.findAllSubjects();
         model.addAttribute("listSubjects", listSubjects);


        List<Document> listDocuments = documentService.findAllDocuments();
        model.addAttribute("listDocuments", listDocuments);
        return "home";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("document") MultipartFile multipartFile,
                            RedirectAttributes ra) throws IOException{
        String fileName = StringUtils.cleanPath( multipartFile.getOriginalFilename());
       
        Document document = new Document();
        document.setName(fileName);
        document.setContent(multipartFile.getBytes());
        document.setSize(multipartFile.getSize());

        document.setUploadTime(new Date());

        documentService.saveDocument(document);

        ra.addFlashAttribute("message","The File has been uploaded sucessfully.");


        return "redirect:/";
    }

    // @RequestMapping(value="/saveActivities", method = RequestMethod.POST)
    // public String saveActivities(@ModelAttribute("activities")Activities activities){
    //     activitiesService.saveActivities(activities);
    //     return "redirect:/";
    // }
   
    // @RequestMapping(value="/saveActivities", method = RequestMethod.POST)

    
    
}
