package br.dcc.ufjf.atividades.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Activities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
     private Student student;

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
     private Subject subject;

    @OneToOne
    @JoinColumn(name = "activities", referencedColumnName = "id")
    private FileActivities fileActivities;


    public Activities() {
    }    
    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public FileActivities getFileActivities() {
        return fileActivities;
    }


    public void setFileActivities(FileActivities fileActivities) {
        this.fileActivities = fileActivities;
    }
    
}
