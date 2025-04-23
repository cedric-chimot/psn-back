package fr.cch.trophees_psn.service;

import fr.cch.trophees_psn.entity.StatsNiveaux;
import fr.cch.trophees_psn.exceptions.CustomException;
import fr.cch.trophees_psn.repository.StatsNiveauxRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatsNiveauxService {

  /**
   * Variable pour appeler le répository
   */
  private final StatsNiveauxRepository statsNiveauxRepository;

  /**
   * Constructeur du service
   * @param statsNiveauxRepository le répo des statistiques de niveau
   */
  public StatsNiveauxService(StatsNiveauxRepository statsNiveauxRepository) {
    this.statsNiveauxRepository = statsNiveauxRepository;
  }

  /**
   * Ajouter une statistique
   * @param statsNiveaux la statistique à ajouter
   * @return la nouvelle statistique
   */
  public StatsNiveaux statsNiveauxSave(StatsNiveaux statsNiveaux) {
    return statsNiveauxRepository.save(statsNiveaux);
  }

  /**
   * Trouver toutes les statistiques
   * @return la liste de toutes les statistiques
   */
  public List<StatsNiveaux> findAllStatsNiveaux() {
    return statsNiveauxRepository.findAll();
  }

  /**
   * Trouver une statistique par son Id
   * @param id l'id de la statsNiveaux
   * @return la statsNiveaux trouvé
   */
  public StatsNiveaux findStatsNiveauxById(Long id) {
    return statsNiveauxRepository.findById(id)
      .orElseThrow(() -> new CustomException("StatsNiveaux", "id", id));
  }

  /**
   * Mettre à jour une stat
   * @param statsNiveaux la statistique à mettre à jour
   * @return la statistique mise à jour
   */
  public StatsNiveaux updateStatsNiveaux(StatsNiveaux statsNiveaux) {
    Optional<StatsNiveaux> existingStatsNiveaux = statsNiveauxRepository.findById(statsNiveaux.getId());

    if(existingStatsNiveaux.isPresent()) {
      StatsNiveaux existingStats = existingStatsNiveaux.get();

      existingStats.setNiveau(statsNiveaux.getNiveau());
      existingStats.setNiveauAnnee(statsNiveaux.getNiveauAnnee());
      return statsNiveauxRepository.save(existingStats);
    } else {
      throw new CustomException("Le statsNiveaux est inconnu", "id", statsNiveaux.getId());
    }
  }

  /**
   * Supprimer une statistique par son id
   * @param id l'id de la statistique à supprimer
   * @return la statistique supprimée
   */
  public StatsNiveaux deleteById(Long id) {
    Optional<StatsNiveaux> optionalStatsNiveaux = statsNiveauxRepository.findById(id);

    if (optionalStatsNiveaux.isPresent()) {
      StatsNiveaux statsNiveaux = optionalStatsNiveaux.get();
      statsNiveauxRepository.delete(statsNiveaux);
      return statsNiveaux;
    } else {
      throw new CustomException("StatsNiveaux", "id",  id);
    }
  }

  /**
   * Supprimer toutes les statistiques de niveau
   */
  public void deleteAll() {
    statsNiveauxRepository.deleteAll();
  }

}
