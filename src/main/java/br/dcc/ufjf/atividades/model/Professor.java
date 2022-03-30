
package br.dcc.ufjf.atividades.model;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private String cpf;

    // @JsonIgnore
    // @ManyToMany(mappedBy = "enrolledProfessors")
    //  private  Set<Professor> subjects = new HashSet<Professor>();
    

    public Professor() {
    }

    public Professor(Long id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // public Set<Professor> getSubjects() {
    //     return subjects;
    // }

    // public void setSubjects(Set<Professor> subjects) {
    //     this.subjects = subjects;
    // }

    

    

}


