package fr.cch.trophees_psn.controller;

import fr.cch.trophees_psn.entity.StatsTrophees;
import fr.cch.trophees_psn.service.StatsTropheesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statsTrophees")
@CrossOrigin
public class StatsTropheesController {

  /**
   * Variable pour appeler le service
   */
  public final StatsTropheesService statsTropheesService;

  /**
   * Le constructeur
   * @param statsTropheesService injection du service statistique de trophee
   */
  public StatsTropheesController(StatsTropheesService statsTropheesService) {
    this.statsTropheesService = statsTropheesService;
  }

  /**
   * Créer une nouvelle statistique
   * @param statsTrophees la statistique à créer
   * @return la nouvelle statistique
   */
  @PostMapping("/create")
  public ResponseEntity<StatsTrophees> createStatsTrophees(@RequestBody StatsTrophees statsTrophees) {
    StatsTrophees savedStatsTrophees = statsTropheesService.statsTropheesSave(
      statsTrophees.getNbPlatine(),
      statsTrophees.getNbOr(),
      statsTrophees.getNbArgent(),
      statsTrophees.getNbBronze(),
      statsTrophees.getTropheeAnnee().getId()
    );
    return ResponseEntity.ok(savedStatsTrophees);
  }

  /**
   * Afficher toutes les statistiques de trophees
   * @return la liste des statistiques de trophees
   */
  @GetMapping("/all")
  public List<StatsTrophees> getAllStatsTrophees() {
    return statsTropheesService.findAllStatsTrophees();
  }

  /**
   * Rechercher une statistique par son id
   *
   * @param id l'id de la statistique
   * @return la statistique trouvée
   */
  @GetMapping("/{id}")
  public StatsTrophees getStatsTropheesById(@PathVariable Long id) {
    return statsTropheesService.findStatsTropheesById(id);
  }

  /**
   * Mettre à jour une statistique
   * @param statsTrophees la statistique à mettre à jour
   * @return la statistique mise à jour
   */
  @PatchMapping("/update")
  public StatsTrophees updateStatsTrophees(@RequestBody StatsTrophees statsTrophees) {
    return statsTropheesService.updateStatsTrophees(statsTrophees);
  }

  /**
   * Supprimer une statistique par son id
   * @param id l'id d'une statistique à supprimer
   * @return la statistique supprimée
   */
  @DeleteMapping("/delete/{id}")
  public StatsTrophees deleteStatsTropheesById(@PathVariable Long id) {
    return statsTropheesService.deleteById(id);
  }

  /**
   * Supprimer toutes les statistiques
   */
  @DeleteMapping("/delete/all")
  public void deleteAllStatsTrophees() {
    statsTropheesService.deleteAll();
  }

}
