package br.dcc.ufjf.atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dcc.ufjf.atividades.model.Professor;

public interface RepositoryProfessor extends JpaRepository<Professor,Long> {
    
}
