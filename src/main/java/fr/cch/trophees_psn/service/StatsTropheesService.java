package fr.cch.trophees_psn.service;

import fr.cch.trophees_psn.entity.Annee;
import fr.cch.trophees_psn.entity.StatsTrophees;
import fr.cch.trophees_psn.exceptions.CustomException;
import fr.cch.trophees_psn.repository.StatsTropheesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StatsTropheesService {

  /**
   * Variable pour appeler le répository
   */
  private final StatsTropheesRepository statsTropheesRepository;

  /**
   * Appel du service des années
   */
  private final AnneeService anneeService;

  /**
   * Constructeur du service
   * @param statsTropheesRepository le répo des statistiques de trophees
   */
  public StatsTropheesService(StatsTropheesRepository statsTropheesRepository, AnneeService anneeService) {
    this.statsTropheesRepository = statsTropheesRepository;
    this.anneeService = anneeService;
  }

  /**
   * Ajouter le nombre de trophées pour une année
   * @param nbPlatine le nombre de platine
   * @param nbOr le nombre de trophées or
   * @param nbArgent le nombre de trophées argent
   * @param nbBronze le nombre de trophées bronze
   * @param idAnnee l'identifiant de l'année
   * @return Le nombre de trophées pour une année
   */
  public StatsTrophees statsTropheesSave(Long nbPlatine, Long nbOr, Long nbArgent, Long nbBronze,
                                         Long idAnnee) {
    Annee annee = anneeService.findAnneeById(idAnnee);

    StatsTrophees statsTrophees = new StatsTrophees(nbPlatine, nbOr, nbArgent, nbBronze, annee);
    return statsTropheesRepository.save(statsTrophees);
  }

  /**
   * Trouver toutes les statistiques
   * @return la liste de toutes les statistiques
   */
  public List<StatsTrophees> findAllStatsTrophees() {
    return statsTropheesRepository.findAll();
  }

  /**
   * Trouver une statistique par son Id
   * @param id l'id de la statsTrophees
   * @return la statsTrophees trouvé
   */
  public StatsTrophees findStatsTropheesById(Long id) {
    return statsTropheesRepository.findById(id)
      .orElseThrow(() -> new CustomException("StatsTrophees", "id", id));
  }

  /**
   * Mettre à jour une stat
   * @param statsTrophees la statistique à mettre à jour
   * @return la statistique mise à jour
   */
  public StatsTrophees updateStatsTrophees(StatsTrophees statsTrophees) {
    Optional<StatsTrophees> existingStatsTrophees = statsTropheesRepository.findById(statsTrophees.getId());

    if(existingStatsTrophees.isPresent()) {
      StatsTrophees existingStats = existingStatsTrophees.get();

      existingStats.setNbPlatine(statsTrophees.getNbPlatine());
      existingStats.setNbOr(statsTrophees.getNbOr());
      existingStats.setNbArgent(statsTrophees.getNbArgent());
      existingStats.setNbBronze(statsTrophees.getNbBronze());
      existingStats.setTropheeAnnee(statsTrophees.getTropheeAnnee());
      return statsTropheesRepository.save(existingStats);
    } else {
      throw new CustomException("Le statsTrophees est inconnu", "id", statsTrophees.getId());
    }
  }

  /**
   * Supprimer une statistique par son id
   * @param id l'id de la statistique à supprimer
   * @return la statistique supprimée
   */
  public StatsTrophees deleteById(Long id) {
    Optional<StatsTrophees> optionalStatsTrophees = statsTropheesRepository.findById(id);

    if (optionalStatsTrophees.isPresent()) {
      StatsTrophees statsTrophees = optionalStatsTrophees.get();
      statsTropheesRepository.delete(statsTrophees);
      return statsTrophees;
    } else {
      throw new CustomException("StatsTrophees", "id",  id);
    }
  }

  /**
   * Supprimer toutes les statistiques de trophees
   */
  public void deleteAll() {
    statsTropheesRepository.deleteAll();
  }

}
