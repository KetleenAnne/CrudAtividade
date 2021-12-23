package br.dcc.ufjf.atividades.model;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="Student")
public class Student {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String cpf;
    
    @Column
    private String birth;

    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledStudents")
    private  Set<Subject> subjects = new HashSet<Subject>();

    // @Column
    // private String registration;

    public Student(){
        
    }
    public Set<Subject> getSubjects() {
        return subjects;
    }
    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
    public int getId(){
        return id;
    }
   // public void setId(int id){
   //     this.id = id;
   // }
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
