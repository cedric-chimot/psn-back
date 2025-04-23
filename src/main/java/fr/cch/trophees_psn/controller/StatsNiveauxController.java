package fr.cch.trophees_psn.controller;

import fr.cch.trophees_psn.entity.StatsNiveaux;
import fr.cch.trophees_psn.service.StatsNiveauxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statsNiveaux")
@CrossOrigin
public class StatsNiveauxController {

  /**
   * Variable pour appeler le service
   */
  public final StatsNiveauxService statsNiveauxService;

  /**
   * Le constructeur
   * @param statsNiveauxService injection du service statistique de niveau
   */
  public StatsNiveauxController(StatsNiveauxService statsNiveauxService) {
    this.statsNiveauxService = statsNiveauxService;
  }

  /**
   * Créer une nouvelle statistique
   * @param statsNiveaux la statistique à créer
   * @return la nouvelle statistique
   */
  @PostMapping("/create")
  public ResponseEntity<StatsNiveaux> createStatsNiveaux(@RequestBody StatsNiveaux statsNiveaux) {
    StatsNiveaux savedStatsNiveaux = statsNiveauxService.statsNiveauxSave(statsNiveaux);
    return ResponseEntity.ok(savedStatsNiveaux);
  }

  /**
   * Afficher toutes les statistiques de niveaux
   * @return la liste des statistiques de niveaux
   */
  @GetMapping("/all")
  public List<StatsNiveaux> getAllStatsNiveaux() {
    return statsNiveauxService.findAllStatsNiveaux();
  }

  /**
   * Rechercher une statistique par son id
   *
   * @param id l'id de la statistique
   * @return la statistique trouvée
   */
  @GetMapping("/{id}")
  public StatsNiveaux getStatsNiveauxById(@PathVariable Long id) {
    return statsNiveauxService.findStatsNiveauxById(id);
  }

  /**
   * Mettre à jour une statistique
   * @param statsNiveaux la statistique à mettre à jour
   * @return la statistique mise à jour
   */
  @PatchMapping("/update")
  public StatsNiveaux updateStatsNiveaux(@RequestBody StatsNiveaux statsNiveaux) {
    return statsNiveauxService.updateStatsNiveaux(statsNiveaux);
  }

  /**
   * Supprimer une statistique par son id
   * @param id l'id d'une statistique à supprimer
   * @return la statistique supprimée
   */
  @DeleteMapping("/delete/{id}")
  public StatsNiveaux deleteStatsNiveauxById(@PathVariable Long id) {
    return statsNiveauxService.deleteById(id);
  }

  /**
   * Supprimer toutes les statistiques
   */
  @DeleteMapping("/delete/all")
  public void deleteAllStatsNiveaux() {
    statsNiveauxService.deleteAll();
  }

}
