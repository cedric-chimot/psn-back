package fr.cch.trophees_psn.service;

import fr.cch.trophees_psn.entity.Jeux;
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

  /*
  * Injection du répository
  * */
  private final JeuxRepository jeuxRepository;

  /**
   * Controller du service
   * @param jeuxRepository le répo des jeux
   */
  public JeuxService(JeuxRepository jeuxRepository) {
    this.jeuxRepository = jeuxRepository;
  }

  /**
   * Ajouter un jeu
   * @param jeu le jeu à ajouter
   * @return le nouveau jeu
   */
  public Jeux jeuSave(Jeux jeu) {
    return jeuxRepository.save(jeu);
  }

  /**
   * Trouver tous les jeux
   * @return la liste de tous les jeux
   */
  public List<Jeux> findAllJeux() {
    return jeuxRepository.findAll();
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
  public Jeux deletById(Long id) {
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
