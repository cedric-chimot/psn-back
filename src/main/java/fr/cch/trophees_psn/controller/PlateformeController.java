package fr.cch.trophees_psn.controller;

import fr.cch.trophees_psn.entity.Plateforme;
import fr.cch.trophees_psn.service.PlateformeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plateforme")
@CrossOrigin
public class PlateformeController {

  /**
   * Variable pour appeler le service
   */
  public final PlateformeService plateformeService;

  /**
   * Le constructeur
   * @param plateformeService injection du service plateforme
   */
  public PlateformeController(PlateformeService plateformeService) {
    this.plateformeService = plateformeService;
  }

  /**
   * Créer une nouvelle plateforme
   * @param plateforme la plateforme à créer
   * @return la nouvelle plateforme
   */
  @PostMapping("/create")
  public ResponseEntity<Plateforme> createPlateforme(@RequestBody Plateforme plateforme) {
    Plateforme savedPlateforme = plateformeService.plateformeSave(plateforme);
    return ResponseEntity.ok(savedPlateforme);
  }

  /**
   * Afficher toutes les plateformes
   * @return la liste des plateformes
   */
  @GetMapping("/all")
  public List<Plateforme> getAllPlateforme() {
    return plateformeService.findAllPlateforme();
  }

  /**
   * Rechercher une plateforme par son id
   *
   * @param id l'id de la plateforme
   * @return la plateforme trouvée
   */
  @GetMapping("/{id}")
  public Plateforme getPlateformeById(@PathVariable Long id) {
    return plateformeService.findPlateformeById(id);
  }

  /**
   * Mettre à jour une plateforme
   * @param plateforme la plateforme à mettre à jour
   * @return la plateforme mise à jour
   */
  @PatchMapping("/update")
  public Plateforme updatePlateforme(@RequestBody Plateforme plateforme) {
    return plateformeService.updatePlateforme(plateforme);
  }

  /**
   * Supprimer une plateforme par son id
   * @param id l'id d'une plateforme à supprimer
   * @return la plateforme supprimée
   */
  @DeleteMapping("/delete/{id}")
  public Plateforme deletePlateformeById(@PathVariable Long id) {
    return plateformeService.deleteById(id);
  }

  /**
   * Supprimer toutes les plateformes
   */
  @DeleteMapping("/delete/all")
  public void deleteAllPlateforme() {
    plateformeService.deleteAll();
  }

}
