package fr.cch.trophees_psn.repository;

import fr.cch.trophees_psn.entity.Trophees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TropheesRepository extends JpaRepository<Trophees, Long> {
}
