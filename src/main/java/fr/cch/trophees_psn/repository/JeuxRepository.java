package fr.cch.trophees_psn.repository;

import fr.cch.trophees_psn.entity.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JeuxRepository extends JpaRepository<Jeux, Long> {

  /**
   * Requête pour afficher les jeux par rapport aux nombres d'heures de jeu estimées
   * @return La liste des jeux classés par temps de jeu
   */
  @Query("SELECT j FROM Jeux j ORDER BY j.nbHeures DESC")
  List<Jeux> findAllSortedByNbHeures();

}
