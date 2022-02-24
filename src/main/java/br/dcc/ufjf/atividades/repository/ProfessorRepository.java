package br.dcc.ufjf.atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.ufjf.atividades.model.Professor;
@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    
}
