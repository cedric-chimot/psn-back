package fr.cch.trophees_psn.repository;

import fr.cch.trophees_psn.entity.Jeux;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeuxRepository extends JpaRepository<Jeux, Long> {
}
