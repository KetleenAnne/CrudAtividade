package br.dcc.ufjf.atividades.controller;
import java.io.IOException;
import java.util.*;
import java.lang.Object;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
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
        
        List<Student> listStudents = studentService.findAllStudents();
        model.addAttribute("listStudents", listStudents);

        List<Subject> listSubjects = subjectService.findAllSubjects();
        model.addAttribute("listSubjects", listSubjects);


        List<Document> listDocuments = documentService.findAllDocuments();
        model.addAttribute("listDocuments", listDocuments);

        List<Activities> listActivities = activitiesService.findAllActivities();
        model.addAttribute("listActivities", listActivities);

        Activities activities = new Activities();
        model.addAttribute("activities",activities);
        return "home";
    }

    @RequestMapping("/newActivities")
    public String showNewActvitiesForm(Model model){
        
        List<Student> listStudents = studentService.findAllStudents();
        model.addAttribute("listStudents", listStudents);

        List<Subject> listSubjects = subjectService.findAllSubjects();
        model.addAttribute("listSubjects", listSubjects);


        List<Document> listDocuments = documentService.findAllDocuments();
        model.addAttribute("listDocuments", listDocuments);

        List<Activities> listActivities = activitiesService.findAllActivities();
        model.addAttribute("listActivities", listActivities);

        Activities activities = new Activities();
        model.addAttribute("activities1",activities);

        return "newActivities";
    }
    @RequestMapping(value = "/uploadActivities", method = RequestMethod.POST)
    public String saveActivities(@ModelAttribute("activities1") Activities activities, @RequestParam("doc") MultipartFile multipartFile, RedirectAttributes ra) throws IOException {

        Document document = documentService.saveDocument(multipartFile);
        ra.addFlashAttribute("message","The File has been uploaded sucessfully.");
        activities.setDocument(document);
        activities.setFileContent(multipartFile.getBytes());

        activitiesService.saveActivities(activities);

        return "redirect:/newActivities";
    }

    @RequestMapping("/editActivities/{id}")
    public ModelAndView showEditActivitiesForm(@PathVariable(name="id") Long id){

            ModelAndView modelAndView = new ModelAndView("editActivities");

            Activities activities = activitiesService.get(id);
               
            List<Student> listStudents = studentService.findAllStudents();
            modelAndView.addObject("listStudents", listStudents);

            List<Subject> listSubjects = subjectService.findAllSubjects();
            modelAndView.addObject("listSubjects", listSubjects);

            modelAndView.addObject("activities1", activities);
            return modelAndView;
    }
    @RequestMapping("/deleteActivities/{id}")
    public String showDeleteActivitiesForm(@PathVariable(name="id") Long id){
        activitiesService.delete(id);
        return "redirect:/newActivities";
    }



    // @PostMapping("/upload")
    // public String uploadFile(@RequestParam("document") MultipartFile multipartFile,
    //     RedirectAttributes ra) throws IOException{
    //     documentService.saveDocument(multipartFile);
    //     ra.addFlashAttribute("message","The File has been uploaded sucessfully.");
    //     return "redirect:/";
    // }

    // @GetMapping("/download")
    // // public void downloadFile(@Param("id") Long id, HttpServletResponse response)throws IOException{
        // Optional <Document> result = documentRepository.findById(id);
        // if(!result.isPresent()) {
            // throw new Exception("Could not find document with ID: " + id);
        // }
        // Document document = result.get();
        // response.setContentType("application/octet-stream");
        // String headerKey = "Content-Disposition";
        // String headerValue = "attachment; filename = " + document.getName();

        // response.setHeader(headerKey, headerValue);
        // ServletOutputStream outputStream = response.getOutputStream();
        // outputStream.write(document.getContent());
        // outputStream.Stream.close();;
    // }

    // @RequestMapping(value="/saveActivities", method = RequestMethod.POST)
    // public String saveActivities(@ModelAttribute("activities")Activities activities){
    //     activitiesService.saveActivities(activities);
    //     return "redirect:/";
    // }
   
    // @RequestMapping(value="/saveActivities", method = RequestMethod.POST)

    
    
}
