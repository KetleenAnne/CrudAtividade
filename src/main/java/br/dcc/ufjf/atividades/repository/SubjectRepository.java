package br.dcc.ufjf.atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.ufjf.atividades.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long>{

}