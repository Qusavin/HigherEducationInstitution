package com.example.hardwarestore.persist.db.postgres;

import com.example.hardwarestore.persist.db.postgres.entity.UniversityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UniversityRepository extends JpaRepository<UniversityEntity, UUID> {
}
