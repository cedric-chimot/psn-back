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
@Table(name = "plateforme")
public class Plateforme {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "plateforme")
  private String plateforme;

  @Override
  public String toString() {
    return "Plateforme{" +
      "id=" + id +
      ", plateforme='" + plateforme + '\'' +
      '}';
  }
}
