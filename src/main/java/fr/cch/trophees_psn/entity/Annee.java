package fr.cch.trophees_psn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "annee")
public class Annee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "annee")
  private String annee;

  @JsonIgnore
  @OneToMany(mappedBy = "tropheeAnnee")
  private List<StatsTrophees> trophees;

  @JsonIgnore
  @OneToMany(mappedBy = "niveauAnnee")
  private List<StatsNiveaux> niveaux;

  @Override
  public String toString() {
    return "Annee{" +
      "id=" + id +
      ", annee='" + annee + '\'' +
      '}';
  }
}
