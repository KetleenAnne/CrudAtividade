package br.dcc.ufjf.atividades.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.dcc.ufjf.atividades.controller_service.ProfessorService;
import br.dcc.ufjf.atividades.model.Professor;

@Controller
public class ProfessorController {

    @Autowired
    ProfessorService professorService;

    @RequestMapping("/newProfessor")
    public String showNewStudentForm(Model model){
        Professor professor = new Professor();
        model.addAttribute("professor", professor);
        return "newProfessor";
    }

    @RequestMapping(value = "/saveProfessor", method=RequestMethod.POST)
    public String saveProfessor(@ModelAttribute("subject") Professor professor){
        professorService.saveProfessor(professor);
        return "redirect:/subject";
    }
}
