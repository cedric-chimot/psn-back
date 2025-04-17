package fr.cch.trophees_psn.repository;

import fr.cch.trophees_psn.entity.StatsTrophees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatsTropheesRepository extends JpaRepository<StatsTrophees, Long> {
}
