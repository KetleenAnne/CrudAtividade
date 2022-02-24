package br.dcc.ufjf.atividades.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String cpf;
    
    @Column
    private String birth;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private  Set<Subject> subjects = new HashSet<Subject>();

    public Student(){
        
    }
    public Student(String name, String cpf, String birth){
        this.name=name;
        this.cpf=cpf;
        this.birth=birth;
    }
    public Set<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name= name;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf=cpf;
    }
    public String getBirth(){
        return birth;
    }
    public void setBirth(String birth){
        this.birth = birth;
    }
    
    
}
