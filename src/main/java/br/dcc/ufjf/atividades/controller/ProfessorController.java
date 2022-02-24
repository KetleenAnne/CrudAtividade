package br.dcc.ufjf.atividades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import br.dcc.ufjf.atividades.controller_service.ProfessorService;
import br.dcc.ufjf.atividades.model.Professor;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping("/professor")
    public String viewProfessorPage(Model model){

        List<Professor> listProfessors =professorService.getProfessors();
        model.addAttribute("listProfessors", listProfessors); 
        return "professor";

    }

    @RequestMapping("/newProfessor")
    public String showNewProfessorForm(Model model){
        Professor professor = new Professor();
        model.addAttribute("professor", professor);
        return "newProfessor";
    }

    @RequestMapping(value = "/saveProfessor", method=RequestMethod.POST)
    public String saveProfessor(@ModelAttribute("professor") Professor professor){
        professorService.saveProfessor(professor);
        return "redirect:/professor";
    }
    @RequestMapping("/editProfessor/{id}")
    public ModelAndView showEditProfessorForm(@PathVariable(name="id") Long id){
        ModelAndView  modelAndView= new ModelAndView("editProfessor");
        
        Professor professor = professorService.get(id);
        modelAndView.addObject("professor", professor);
        return modelAndView;
    }

    @RequestMapping("/deleteProfessor/{id}")
    public String showDeleteProfessorForm(@PathVariable(name="id") Long id){
        professorService.delete(id); 
        return "redirect:/professor";
    }
}
