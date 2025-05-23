package fr.cch.trophees_psn.repository;

import fr.cch.trophees_psn.entity.StatsNiveaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatsNiveauxRepository extends JpaRepository<StatsNiveaux, Long> {

  /**
   * Requête pour afficher les stats de niveaux par ordre décroissant d'année
   * @return La liste des stats niveaux classés par année
   */
  @Query("SELECT sn FROM StatsNiveaux sn ORDER BY sn.niveauAnnee DESC")
  List<StatsNiveaux> findAllSortedByAnnees();

}
