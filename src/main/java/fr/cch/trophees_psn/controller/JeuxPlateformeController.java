package fr.cch.trophees_psn.controller;

import fr.cch.trophees_psn.entity.JeuxPlateforme;
import fr.cch.trophees_psn.service.JeuxPlateformeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jeuxPlateforme")
@CrossOrigin
public class JeuxPlateformeController {

  /**
   * Variable pour appeler le service
   */
  public final JeuxPlateformeService jeuxPlateformeService;

  /**
   * Le constructeur
   * @param jeuxPlateformeService injection du service pour l'association jeux/plateforme
   */
  public JeuxPlateformeController(JeuxPlateformeService jeuxPlateformeService) {
    this.jeuxPlateformeService = jeuxPlateformeService;
  }

  /**
   * Créer une nouvelle l'association jeux/plateforme
   * @param jeuxPlateforme la l'association jeux/plateforme à créer
   * @return la nouvelle l'association jeux/plateforme
   */
  @PostMapping("/create")
  public ResponseEntity<JeuxPlateforme> createJeuxPlateforme(@RequestBody JeuxPlateforme jeuxPlateforme) {
    JeuxPlateforme savedJeuxPlateforme = jeuxPlateformeService.jeuPlateformeSave(
      jeuxPlateforme.getJeu().getId(),
      jeuxPlateforme.getPlateforme().getId(),
      jeuxPlateforme.getNbPlatine(),
      jeuxPlateforme.getNbOr(),
      jeuxPlateforme.getNbArgent(),
      jeuxPlateforme.getNbBronze(),
      jeuxPlateforme.getNbHeures()
    );
    return ResponseEntity.ok(savedJeuxPlateforme);
  }

  /**
   * Afficher toutes les l'association jeux/plateforme
   * @return la liste des l'association jeux/plateforme
   */
  @GetMapping("/all")
  public List<JeuxPlateforme> getAllJeuxPlateforme() {
    return jeuxPlateformeService.findAllJeuxPlateforme();
  }

  /**
   * Rechercher une l'association jeux/plateforme par son id
   *
   * @param id l'id de la l'association jeux/plateforme
   * @return la l'association jeux/plateforme trouvée
   */
  @GetMapping("/{id}")
  public JeuxPlateforme getJeuxPlateformeById(@PathVariable Long id) {
    return jeuxPlateformeService.findJeuxPlateformeById(id);
  }

  /**
   * Mettre à jour une l'association jeux/plateforme
   * @param jeuxPlateforme la l'association jeux/plateforme à mettre à jour
   * @return la l'association jeux/plateforme mise à jour
   */
  @PatchMapping("/update")
  public JeuxPlateforme updateJeuxPlateforme(@RequestBody JeuxPlateforme jeuxPlateforme) {
    return jeuxPlateformeService.updateJeuxPlateforme(jeuxPlateforme);
  }

  /**
   * Supprimer une l'association jeux/plateforme par son id
   * @param id l'id d'une l'association jeux/plateforme à supprimer
   * @return la l'association jeux/plateforme supprimée
   */
  @DeleteMapping("/delete/{id}")
  public JeuxPlateforme deleteJeuxPlateformeById(@PathVariable Long id) {
    return jeuxPlateformeService.deleteById(id);
  }

  /**
   * Supprimer toutes les l'association jeux/plateforme
   */
  @DeleteMapping("/delete/all")
  public void deleteAllJeuxPlateforme() {
    jeuxPlateformeService.deleteAll();
  }

}
