package fr.cch.trophees_psn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

  @JsonIgnore
  @ManyToMany
  @JoinTable(
    name = "jeux_plateforme",
    joinColumns = @JoinColumn(name = "id_jeu"),
    inverseJoinColumns = @JoinColumn(name = "id_plateforme")
  )
  private Set<Plateforme> plateformes = new HashSet<>();

  @Override
  public String toString() {
    return "Jeux{" +
      "id=" + id +
      ", jeu='" + jeu + '\'' +
      '}';
  }
}
