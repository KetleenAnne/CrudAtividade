package br.dcc.ufjf.atividades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.ufjf.atividades.model.Student;



@Repository
public interface RepositoryStudent extends JpaRepository<Student,Long>{
    public List<Student> findByName(String name);
}