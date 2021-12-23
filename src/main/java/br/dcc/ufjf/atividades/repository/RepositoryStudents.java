package br.dcc.ufjf.atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.ufjf.atividades.model.Student;



@Repository
public interface RepositoryStudents extends JpaRepository<Student,Integer>{

}