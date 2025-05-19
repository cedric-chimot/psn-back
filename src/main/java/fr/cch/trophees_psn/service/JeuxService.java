package fr.cch.trophees_psn.service;

import fr.cch.trophees_psn.entity.Jeux;
import fr.cch.trophees_psn.entity.Plateforme;
import fr.cch.trophees_psn.exceptions.CustomException;
import fr.cch.trophees_psn.repository.JeuxRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Le service des jeux
 */
@Service
@Transactional
public class JeuxService {

  /**
   * Variable pour appeler le répository
   */
  private final JeuxRepository jeuxRepository;

  /**
   * Appel du service des plateformes
   */
  private final PlateformeService plateformeService;

  /**
   * Controller du service
   * @param jeuxRepository le répo des jeux
   * @param plateformeService le service des plateformes
   */
  public JeuxService(JeuxRepository jeuxRepository, PlateformeService plateformeService) {
    this.jeuxRepository = jeuxRepository;
    this.plateformeService = plateformeService;
  }

  /**
   * Ajouter un jeu
   * @param jeu le nom du jeu
   * @param idPlateforme la plateforme
   * @param nbPlatine le nombre de trophées platine
   * @param nbOr le nombre de trophées or
   * @param nbArgent le nombre de trophées argent
   * @param nbBronze le nombre de trophées bronze
   * @param nbHeures le nombre d'heures de jeu
   * @return le nouveau jeu ajouté
   */
  public Jeux jeuSave(String jeu, Long idPlateforme, Long nbPlatine, Long nbOr, Long nbArgent, Long nbBronze, Long nbHeures) {
    Plateforme plateforme = plateformeService.findPlateformeById(idPlateforme);

    Jeux jeux = new Jeux(jeu, plateforme, nbPlatine, nbOr, nbArgent, nbBronze, nbHeures);
    return jeuxRepository.save(jeux);
  }

  /**
   * Trouver tous les jeux
   * @return la liste de tous les jeux
   */
  public List<Jeux> findAllJeux() {
    return jeuxRepository.findAllSortedByNbHeures();
  }

  /**
   * Trouver un jeu par son Id
   * @param id l'id du jeu
   * @return le jeu trouvé
   */
  public Jeux findJeuById(Long id) {
    return jeuxRepository.findById(id)
      .orElseThrow(() -> new CustomException("Jeu", "id", id));
  }

  /**
   * Mettre à jour un jeu
   * @param jeu le jeu à mettre à jour
   * @return le jeu mis à jour
   */
  public Jeux updateJeu(Jeux jeu) {
    Optional<Jeux> existingJeux = jeuxRepository.findById(jeu.getId());

    if(existingJeux.isPresent()) {
      Jeux existingJeu = existingJeux.get();

      existingJeu.setJeu(jeu.getJeu());
      existingJeu.setPlateforme(jeu.getPlateforme());
      existingJeu.setNbPlatine(jeu.getNbPlatine());
      existingJeu.setNbOr(jeu.getNbOr());
      existingJeu.setNbArgent(jeu.getNbArgent());
      existingJeu.setNbBronze(jeu.getNbBronze());
      existingJeu.setNbHeures(jeu.getNbHeures());
      return jeuxRepository.save(existingJeu);
    } else {
      throw new CustomException("Le jeu est inconnu", "id", jeu.getId());
    }
  }

  /**
   * Supprimer un jeu par son id
   * @param id l'id du jeu à supprimer
   * @return le jeu supprimé
   */
  public Jeux deleteById(Long id) {
    Optional<Jeux> optionalJeux = jeuxRepository.findById(id);

    if (optionalJeux.isPresent()) {
      Jeux jeu = optionalJeux.get();
      jeuxRepository.delete(jeu);
      return jeu;
    } else {
      throw new CustomException("Jeu", "id",  id);
    }
  }

  /**
   * Supprimer tous les jeux
   */
  public void deleteAll() {
    jeuxRepository.deleteAll();
  }

}
