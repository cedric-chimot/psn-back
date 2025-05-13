package fr.cch.trophees_psn.service;

import fr.cch.trophees_psn.entity.Jeux;
import fr.cch.trophees_psn.entity.JeuxPlateforme;
import fr.cch.trophees_psn.entity.Plateforme;
import fr.cch.trophees_psn.exceptions.CustomException;
import fr.cch.trophees_psn.repository.JeuxPlateformeRepository;
import fr.cch.trophees_psn.repository.JeuxRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JeuxPlateformeService {

  /**
   * Variable pour appeler le répository
   */
  private final JeuxPlateformeRepository jeuxPlateformeRepository;

  /**
   * Variable pour appeler le service des plateformes
   */
  private final PlateformeService plateformeService;

    /**
   * Variable pour appeler le service des jeux
   */
  private final JeuxService jeuxService;

  /**
   * Controller du service
   * @param jeuxPlateformeRepository le répo des associations jeux/plateforme
   */
  public JeuxPlateformeService(JeuxPlateformeRepository jeuxPlateformeRepository, PlateformeService plateformeService, JeuxService jeuxService) {
    this.jeuxPlateformeRepository = jeuxPlateformeRepository;
    this.plateformeService = plateformeService;
    this.jeuxService = jeuxService;
  }

  /**
   * Ajouter une association jeux/plateforme
   * @param jeu l'association à ajouter
   * @return la nouvelle association ajoutée
   */
  public JeuxPlateforme jeuSave(Long idJeu, Long idPlateforme, Long nbPlatine, Long nbOr, Long nbArgent,
                                Long nbBronze, Long nbHeures) {
    Jeux jeu = jeuxService.findJeuById(idJeu);
    Plateforme plateforme = plateformeService.findPlateformeById(idPlateforme);

    JeuxPlateforme jeuxPlateforme = new JeuxPlateforme(jeu, plateforme, nbPlatine, nbOr, nbArgent, nbBronze, nbHeures);
    return jeuxPlateformeRepository.save(jeuxPlateforme);
  }

  /**
   * Trouver toutes les association jeux/plateforme
   * @return la liste de tous les jeuxPlateforme
   */
  public List<JeuxPlateforme> findAllJeuxPlateforme() {
    return jeuxPlateformeRepository.findAll();
  }

  /**
   * Trouver une association jeux/plateforme par son Id
   * @param id l'id de l'association jeux/plateforme
   * @return l'association jeux/plateforme trouvé
   */
  public JeuxPlateforme findJeuById(Long id) {
    return jeuxPlateformeRepository.findById(id)
      .orElseThrow(() -> new CustomException("Jeu", "id", id));
  }

  /**
   * Mettre à jour une association jeux/plateforme
   * @param jeu l'association jeux/plateforme à mettre à jour
   * @return l'association jeux/plateforme mise à jour
   */
  public JeuxPlateforme updateJeu(JeuxPlateforme jeuPlateforme) {
    Optional<JeuxPlateforme> existingJeuxPlateforme = jeuxPlateformeRepository.findById(jeuPlateforme.getId());

    if(existingJeuxPlateforme.isPresent()) {
      JeuxPlateforme existingJeu = existingJeuxPlateforme.get();

      existingJeu.setJeu(jeuPlateforme.getJeu());
      existingJeu.setPlateforme(jeuPlateforme.getPlateforme());
      existingJeu.setNbPlatine(jeuPlateforme.getNbPlatine());
      existingJeu.setNbOr(jeuPlateforme.getNbOr());
      existingJeu.setNbArgent(jeuPlateforme.getNbArgent());
      existingJeu.setNbBronze(jeuPlateforme.getNbBronze());
      existingJeu.setNbHeures(jeuPlateforme.getNbHeures());
      return jeuxPlateformeRepository.save(existingJeu);
    } else {
      throw new CustomException("Le jeu est inconnu", "id", jeuPlateforme.getId());
    }
  }

  /**
   * Supprimer une association jeux/plateforme par son id
   * @param id l'id de l'association jeux/plateforme à supprimer
   * @return l'association jeux/plateforme supprimé
   */
  public JeuxPlateforme deleteById(Long id) {
    Optional<JeuxPlateforme> optionalJeuxPlateforme = jeuxPlateformeRepository.findById(id);

    if (optionalJeuxPlateforme.isPresent()) {
      JeuxPlateforme jeu = optionalJeuxPlateforme.get();
      jeuxPlateformeRepository.delete(jeu);
      return jeu;
    } else {
      throw new CustomException("Jeu", "id",  id);
    }
  }

  /**
   * Supprimer toutes les association jeux/plateforme
   */
  public void deleteAll() {
    jeuxPlateformeRepository.deleteAll();
  }

}
