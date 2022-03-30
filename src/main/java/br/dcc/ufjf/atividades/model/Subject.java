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

    @ManyToMany
    @JoinTable(
        name = "student_enrolled",
        joinColumns = @JoinColumn(name="subject_id"),
        inverseJoinColumns = @JoinColumn(name="student_id")
    )
    private Set<Student> enrolledStudents = new HashSet<Student>();

    // @ManyToMany
    // @JoinTable(
    //     name ="professor_enrolled",
    //     joinColumns = @JoinColumn(name="subject_id"),
    //     inverseJoinColumns = @JoinColumn(name = "professor_id")
    // // )
    // private Set<Professor> enrolledProfessors = new HashSet<Professor>();
    
    public Subject( String disciplineCode, String name) {
        this.disciplineCode = disciplineCode;
        this.name = name;
    }

    public Subject(){

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


     public void enrollStudent(Student student) {
         enrolledStudents.add(student);
     }

     
    public Set<Student> getListStudents() {
        return enrolledStudents;
    }

    public void setListStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

//     public Set<Professor> getEnrolledProfessors() {
//         return enrolledProfessors;
//     }

//     public void setEnrolledProfessors(Set<Professor> enrolledProfessors) {
//         this.enrolledProfessors = enrolledProfessors;
//     } 
//     public void enrollProfessor(Professor professor){
//         enrolledProfessors.add(professor);
//     }

}
