package com.example.entreprise.Repository;

import com.example.entreprise.Entity.Entreprise;
import com.example.entreprise.Entity.ProjetDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EntrepriseRepo extends JpaRepository<Entreprise,Long> {
    @Query("SELECT e FROM Entreprise e WHERE e.adresse =:adresse")
    List<Entreprise> retrieveEntreprisesByAdresse(@Param("adresse") String adresse);

    @Query("SELECT entreprise FROM Entreprise entreprise , Equipe equipe where
            entreprise.id = equipe.entreprise.id and equipe.specialite =:specialite")
    List<Entreprise> retrieveEntreprisesBySpecialiteEquipe(@Param("specialite") String specialite);

    @Modifying
    @Query("update Entreprise e set e.adresse = :adresse where e.idEntreprise =
            :idEntreprise")
            int updateEntrepriseByAdresse(@Param("adresse") String adresse,
            @Param("idEntreprise")
            Long idEntreprise);
    @Modifying
    @Query("DELETE FROM Entreprise e WHERE e.adresse= :adresse")
    int deleteFournisseurByCategorieFournisseur(@Param("adresse") String adresse);

}
