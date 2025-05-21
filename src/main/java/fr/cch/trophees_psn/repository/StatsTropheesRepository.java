package fr.cch.trophees_psn.repository;

import fr.cch.trophees_psn.entity.StatsTrophees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatsTropheesRepository extends JpaRepository<StatsTrophees, Long> {

  /**
   * Requête pour afficher les stats de trophées par ordre décroissant d'année
   * @return La liste des stats trophées classés par année
   */
  @Query("SELECT st FROM StatsTrophees st ORDER BY st.tropheeAnnee DESC")
  List<StatsTrophees> findAllSortedByAnnees();

}
