package br.dcc.ufjf.atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.ufjf.atividades.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration,Long> {
    
}
