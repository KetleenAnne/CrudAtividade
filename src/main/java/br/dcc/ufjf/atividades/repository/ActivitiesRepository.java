package br.dcc.ufjf.atividades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.dcc.ufjf.atividades.model.Activities;


@Repository
public interface ActivitiesRepository extends JpaRepository<Activities,Long>{
    
}
