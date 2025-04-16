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
  @JoinColumn(name = "jeu_id", nullable = false)
  private Jeux jeu;

  @ManyToOne
  @JoinColumn(name = "plateforme_id", nullable = false)
  private Plateforme plateforme;

  @Column(name = "nb_platine")
  private Long nbPlatine;

  @Column(name = "nb_or")
  private Long nbOr;

  @Column(name = "nb_argent")
  private Long nbArgent;

  @Column(name = "nb_bronze")
  private Long nbBronze;

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
      '}';
  }
}
