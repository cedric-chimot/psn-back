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
@Table(name = "stats_trophees")
public class StatsTrophees {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nb_platine")
  private Long nbPlatine;

  @Column(name = "nb_or")
  private Long nbOr;

  @Column(name = "nb_argent")
  private Long nbArgent;

  @Column(name = "nb_bronze")
  private Long nbBronze;

  @ManyToOne
  @JoinColumn(name = "id_annee", nullable = false)
  private Annee tropheeAnnee;

  public StatsTrophees(Long nbPlatine, Long nbOr, Long nbArgent, Long nbBronze, Annee tropheeAnnee) {
    this.nbPlatine = nbPlatine;
    this.nbOr = nbOr;
    this.nbArgent = nbArgent;
    this.nbBronze = nbBronze;
    this.tropheeAnnee = tropheeAnnee;
  }

  @Override
  public String toString() {
    return "StatsTrophees{" +
      "id=" + id +
      ", nbPlatine=" + nbPlatine +
      ", nbOr=" + nbOr +
      ", nbArgent=" + nbArgent +
      ", nbBronze=" + nbBronze +
      ", tropheeAnnee=" + tropheeAnnee +
      '}';
  }

}
