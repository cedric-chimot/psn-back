package fr.cch.trophees_psn.service;

import fr.cch.trophees_psn.entity.Plateforme;
import fr.cch.trophees_psn.exceptions.CustomException;
import fr.cch.trophees_psn.repository.PlateformeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlateformeService {

  /**
   * Variable pour appeler le répository
   */
  private final PlateformeRepository plateformeRepository;

  /**
   * Constructeur du service
   * @param plateformeRepository le répo des plateformes
   */
  public PlateformeService(PlateformeRepository plateformeRepository) {
    this.plateformeRepository = plateformeRepository;
  }

  /**
   * Ajouter une plateforme
   * @param plateforme la plateforme à ajouter
   * @return la nouvelle plateforme
   */
  public Plateforme plateformeSave(Plateforme plateforme) {
    return plateformeRepository.save(plateforme);
  }

  /**
   * Trouver toutes les plateformes
   * @return la liste de toutes les plateformes
   */
  public List<Plateforme> findAllPlateforme() {
    return plateformeRepository.findAll();
  }

  /**
   * Trouver une plateforme par son Id
   * @param id l'id de la plateforme
   * @return la plateforme trouvé
   */
  public Plateforme findPlateformeById(Long id) {
    return plateformeRepository.findById(id)
      .orElseThrow(() -> new CustomException("Plateforme", "id", id));
  }

  /**
   * Mettre à jour une plateforme
   * @param plateforme la plateforme à mettre à jour
   * @return la plateforme mise à jour
   */
  public Plateforme updatePlateforme(Plateforme plateforme) {
    Optional<Plateforme> existingPlateforme = plateformeRepository.findById(plateforme.getId());

    if(existingPlateforme.isPresent()) {
      Plateforme existingPlateformes = existingPlateforme.get();

      existingPlateformes.setPlateforme(plateforme.getPlateforme());
      return plateformeRepository.save(existingPlateformes);
    } else {
      throw new CustomException("Le plateforme est inconnu", "id", plateforme.getId());
    }
  }

  /**
   * Supprimer une plateforme par son id
   * @param id l'id de la plateforme à supprimer
   * @return la plateforme supprimée
   */
  public Plateforme deleteById(Long id) {
    Optional<Plateforme> optionalPlateforme = plateformeRepository.findById(id);

    if (optionalPlateforme.isPresent()) {
      Plateforme plateforme = optionalPlateforme.get();
      plateformeRepository.delete(plateforme);
      return plateforme;
    } else {
      throw new CustomException("Plateforme", "id",  id);
    }
  }

  /**
   * Supprimer toutes les plateformes
   */
  public void deleteAll() {
    plateformeRepository.deleteAll();
  }

}
