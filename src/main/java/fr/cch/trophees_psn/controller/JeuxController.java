package fr.cch.trophees_psn.controller;

import fr.cch.trophees_psn.entity.Jeux;
import fr.cch.trophees_psn.service.JeuxService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jeux")
@CrossOrigin
public class JeuxController {

  public final JeuxService jeuxService;

  public JeuxController(JeuxService jeuxService) {
    this.jeuxService = jeuxService;
  }

  /**
   * Créer un nouveau jeu
   * @param jeu le jeu à créer
   * @return le nouveau jeu
   */
  @PostMapping("/create")
  public ResponseEntity<Jeux> createJeu(@RequestBody Jeux jeu) {
    Jeux savedJeu = jeuxService.jeuSave(jeu);
    return ResponseEntity.ok(savedJeu);
  }

  /**
   * Afficher tous les jeux
   * @return la liste des jeux
   */
  @GetMapping("/all")
  public List<Jeux> getAllJeux() {
    return jeuxService.findAllJeux();
  }

  /**
   * Rechercher un jeu par son id
   *
   * @param id l'id de la jeu
   * @return le jeu trouvé
   */
  @GetMapping("/{id}")
  public Jeux getJeuById(@PathVariable Long id) {
    return jeuxService.findJeuById(id);
  }

  /**
   * Mettre à jour un jeu
   * @param jeu le jeu à mettre à jour
   * @return le jeu mis à jour
   */
  @PatchMapping("/update")
  public Jeux updateJeu(@RequestBody Jeux jeu) {
    return jeuxService.updateJeu(jeu);
  }

  /**
   * Supprimer un jeu par son id
   * @param id l'id d'un jeu à supprimer
   * @return le jeu supprimé
   */
  @DeleteMapping("/delete/{id}")
  public Jeux deleteJeuById(@PathVariable Long id) {
    return jeuxService.deletById(id);
  }

  /**
   * Supprimer toutes les jeuxs
   */
  @DeleteMapping("/delete/all")
  public void deleteAllJeux() {
    jeuxService.deleteAll();
  }

}
