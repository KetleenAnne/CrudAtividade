package br.dcc.ufjf.atividades.model;



import java.util.*;

import javax.persistence.*;



@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id; /*id da disciplina*/

    @Column 
    private String disciplineCode; /*codigo da disciplina*/
    
    @Column 
    private String name; /*nome da disciplina */

    @Column
    private String registration; /*matricula do aluno*/

    @ManyToMany
    @JoinTable(
        name = "student_enrolled",
        joinColumns = @JoinColumn(name="subject_id"),
        inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<Student>();
    
    public Subject(){

    }

    // public List<Students> getListStudents() {
    //     return this.listStudents;
    // }

    // public void setListStudents(List<Students> listStudents) {
    //     this.listStudents = listStudents;
    // }


    public Set<Student> getListStudents() {
        return enrolledStudents;
    }

    public void setListStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Long getId(){
        return id;
    }
     public void setId(Long id){
        this.id =id;
    }
   
    public String getDisciplineCode(){
        return disciplineCode;
    }
    public void setDisciplineCode(String disciplineCode){
        this.disciplineCode = disciplineCode;
    }

    public String getName(){
        return name;
    }
    public  void setName(String name){
        this.name = name;
    }

     public String getRegistration(){
         return registration;
     }
     public void setRegistration(String registration){
         this.registration=registration;
     }

    // public void enrollStudent(Student student) {
    //     enrolledStudents.add(student);
    // } 
    
}
