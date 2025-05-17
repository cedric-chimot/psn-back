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
@Table(name = "jeux")
public class Jeux {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "jeu")
  private String jeu;

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

  public Jeux(String jeu, Plateforme plateforme, Long nbPlatine, Long nbOr, Long nbArgent, Long nbBronze, Long nbHeures) {
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
    return "Jeux{" +
      "id=" + id +
      ", jeu='" + jeu + '\'' +
      '}';
  }
}
