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
@Table(name = "stats_niveaux")
public class StatsNiveaux {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "niveau")
  private Long niveau;

  @ManyToOne
  @JoinColumn(name = "id_annee", nullable = false)
  private Annee niveauAnnee;

  @Override
  public String toString() {
    return "StatsNiveaux{" +
      "id=" + id +
      ", niveau=" + niveau +
      '}';
  }
}
