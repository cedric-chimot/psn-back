package fr.cch.trophees_psn.repository;

import fr.cch.trophees_psn.entity.JeuxPlateforme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuxPlateformeRepository extends JpaRepository<JeuxPlateforme, Long> {
}
