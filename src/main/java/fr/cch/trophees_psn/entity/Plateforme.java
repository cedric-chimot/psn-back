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
@Table(name = "plateforme")
public class Plateforme {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "plateforme")
  private String plateforme;

  @JsonIgnore
  @OneToMany(mappedBy = "plateforme")
  private List<Plateforme> plateformes;

  @Override
  public String toString() {
    return "Plateforme{" +
      "id=" + id +
      ", plateforme='" + plateforme + '\'' +
      '}';
  }
}
