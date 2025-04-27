package fr.cch.trophees_psn.controller;

import fr.cch.trophees_psn.entity.Annee;
import fr.cch.trophees_psn.service.AnneeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/année")
@CrossOrigin
public class AnneeController {

  /**
   * Variable pour appeler le service
   */
  public final AnneeService anneeService;

  /**
   * Le constructeur
   * @param anneeService injection du service année
   */
  public AnneeController(AnneeService anneeService) {
    this.anneeService = anneeService;
  }

  /**
   * Créer une nouvelle année
   * @param année l'année à créer
   * @return la nouvelle année
   */
  @PostMapping("/create")
  public ResponseEntity<Annee> createAnnee(@RequestBody Annee année) {
    Annee savedAnnee = anneeService.anneeSave(année);
    return ResponseEntity.ok(savedAnnee);
  }

  /**
   * Afficher toutes les années
   * @return la liste des années
   */
  @GetMapping("/all")
  public List<Annee> getAllAnnee() {
    return anneeService.findAllAnnee();
  }

  /**
   * Rechercher une année par son id
   *
   * @param id l'id de l'année
   * @return l'année trouvé
   */
  @GetMapping("/{id}")
  public Annee getAnneeById(@PathVariable Long id) {
    return anneeService.findAnneeById(id);
  }

  /**
   * Mettre à jour une année
   * @param année l'année à mettre à jour
   * @return l'année mis à jour
   */
  @PatchMapping("/update")
  public Annee updateAnnee(@RequestBody Annee année) {
    return anneeService.updateAnnee(année);
  }

  /**
   * Supprimer une année par son id
   * @param id l'id d'une année à supprimer
   * @return l'année supprimée
   */
  @DeleteMapping("/delete/{id}")
  public Annee deleteAnneeById(@PathVariable Long id) {
    return anneeService.deleteById(id);
  }

  /**
   * Supprimer toutes les années
   */
  @DeleteMapping("/delete/all")
  public void deleteAllAnnee() {
    anneeService.deleteAll();
  }

}
