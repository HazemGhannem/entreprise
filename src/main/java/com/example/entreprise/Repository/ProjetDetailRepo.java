package com.example.entreprise.Repository;

import com.example.entreprise.Entity.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetDetailRepo  extends JpaRepository<ProjetDetail,Long> {
}
