package com.example.entreprise.Repository;

import com.example.entreprise.Entity.Equipe;
import com.example.entreprise.Entity.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EquipeRepo extends JpaRepository<Equipe,Long> {
}
