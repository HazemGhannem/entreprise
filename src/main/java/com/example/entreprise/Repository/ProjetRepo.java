package com.example.entreprise.Repository;

import com.example.entreprise.Entity.Equipe;
import com.example.entreprise.Entity.Projet;
import com.example.entreprise.Entity.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ProjetRepo extends JpaRepository<Projet,Long> {

    @Query("SELECT projet FROM Projet projet, ProjetDetail detail where "
            + "detail.idProjetDetail = projet.projetDetail.idProjetDetail "
            + "and detail.technologie =:technologie "
            + "and detail.cout_provisoire >:cout_provisoire")

    List<Projet> retrieveProjetsByCoutAndTechnologie(@Param("technologie") String technologie,

                                                     @Param("cout_provisoire") Long cout_provisoire);

    @Query("SELECT equipe FROM Equipe equipe"
            + " INNER JOIN equipe.projets projet"
            + " INNER JOIN ProjetDetail detail"
            + " ON detail.idProjetDetail = projet.projetDetail.idProjetDetail"
            + " where detail.dateDebut > current_date"
            + " and detail.technologie =:technologie")
    List<Equipe> retrieveEquipesByProjetTechnologie(@Param("technologie")
                                                    String technologie);
    @Modifying
    @Query(value = "INSERT INTO T_Projet(projet_sujet) VALUES (:projetsujet)",
            nativeQuery = true)
    void insertProjet(@Param("projetsujet") String projetsujet);
}
