package fr.cch.trophees_psn.service;

import fr.cch.trophees_psn.entity.Annee;
import fr.cch.trophees_psn.exceptions.CustomException;
import fr.cch.trophees_psn.repository.AnneeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnneeService {

  /**
   * Variable pour appeler le répository
   */
  private final AnneeRepository anneeRepository;

  /**
   * Controller du service
   * @param anneeRepository le répo des années
   */
  public AnneeService(AnneeRepository anneeRepository) {
    this.anneeRepository = anneeRepository;
  }

  /**
   * Ajouter une année
   * @param annee l'année à ajouter
   * @return le nouveau annee
   */
  public Annee anneeSave(Annee annee) {
    return anneeRepository.save(annee);
  }

  /**
   * Trouver tous les annee
   * @return la liste de toutes les années
   */
  public List<Annee> findAllAnnee() {
    return anneeRepository.findAll();
  }

  /**
   * Trouver un annee par son Id
   * @param id l'id de l'année
   * @return l'année trouvé
   */
  public Annee findAnneeById(Long id) {
    return anneeRepository.findById(id)
      .orElseThrow(() -> new CustomException("Annee", "id", id));
  }

  /**
   * Mettre à jour une année
   * @param annee l'année à mettre à jour
   * @return l'année mis à jour
   */
  public Annee updateAnnee(Annee annee) {
    Optional<Annee> existingAnnee = anneeRepository.findById(annee.getId());

    if(existingAnnee.isPresent()) {
      Annee annePresent = existingAnnee.get();

      annePresent.setAnnee(annee.getAnnee());
      return anneeRepository.save(annePresent);
    } else {
      throw new CustomException("Le annee est inconnu", "id", annee.getId());
    }
  }

  /**
   * Supprimer une année par son id
   * @param id l'id de l'année à supprimer
   * @return l'année supprimé
   */
  public Annee deleteById(Long id) {
    Optional<Annee> optionalAnnee = anneeRepository.findById(id);

    if (optionalAnnee.isPresent()) {
      Annee annee = optionalAnnee.get();
      anneeRepository.delete(annee);
      return annee;
    } else {
      throw new CustomException("Annee", "id",  id);
    }
  }

  /**
   * Supprimer toutes les années
   */
  public void deleteAll() {
    anneeRepository.deleteAll();
  }

}
