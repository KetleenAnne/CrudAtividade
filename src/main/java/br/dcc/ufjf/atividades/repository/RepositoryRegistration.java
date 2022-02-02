package br.dcc.ufjf.atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dcc.ufjf.atividades.model.Registration;

public interface RepositoryRegistration extends JpaRepository<Registration,Long> {
    
}
