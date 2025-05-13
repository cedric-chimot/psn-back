package fr.cch.trophees_psn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jeux_plateforme")
public class JeuxPlateforme {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id_jeu", nullable = false)
  private Jeux jeu;

  @ManyToOne
  @JoinColumn(name = "id_plateforme", nullable = false)
  private Plateforme plateforme;

  @Column(name = "nb_platine")
  private Long nbPlatine;

  @Column(name = "nb_or")
  private Long nbOr;

  @Column(name = "nb_argent")
  private Long nbArgent;

  @Column(name = "nb_bronze")
  private Long nbBronze;

  @Column(name = "nb_heures")
  private Long nbHeures;

  public JeuxPlateforme(Jeux jeu, Plateforme plateforme, Long nbPlatine, Long nbOr, Long nbArgent, Long nbBronze, Long nbHeures) {
    this.jeu = jeu;
    this.plateforme = plateforme;
    this.nbPlatine = nbPlatine;
    this.nbOr = nbOr;
    this.nbArgent = nbArgent;
    this.nbBronze = nbBronze;
    this.nbHeures = nbHeures;
  }

  @Override
  public String toString() {
    return "JeuxPlateforme{" +
      "id=" + id +
      ", jeu=" + jeu +
      ", plateforme=" + plateforme +
      ", nbPlatine=" + nbPlatine +
      ", nbOr=" + nbOr +
      ", nbArgent=" + nbArgent +
      ", nbBronze=" + nbBronze +
      ", nbHeures=" + nbHeures +
      '}';
  }
}
