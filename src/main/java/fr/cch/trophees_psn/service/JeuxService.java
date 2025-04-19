package fr.cch.trophees_psn.service;

import fr.cch.trophees_psn.entity.Jeux;
import fr.cch.trophees_psn.exceptions.CustomException;
import fr.cch.trophees_psn.repository.JeuxRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JeuxService {

  private final JeuxRepository jeuxRepository;

  public JeuxService(JeuxRepository jeuxRepository) {
    this.jeuxRepository = jeuxRepository;
  }

  public Jeux jeuSave(Jeux jeu) {
    return jeuxRepository.save(jeu);
  }

  public List<Jeux> findAllJeux() {
    return jeuxRepository.findAll();
  }

  public Jeux findJeuById(Long id) {
    return jeuxRepository.findById(id)
      .orElseThrow(() -> new CustomException("Jeu", "id", id));
  }

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

  public void deleteAll() {
    jeuxRepository.deleteAll();
  }

}
