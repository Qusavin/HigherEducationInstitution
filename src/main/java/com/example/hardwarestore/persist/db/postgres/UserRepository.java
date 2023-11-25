package com.example.hardwarestore.persist.db.postgres;

import com.example.hardwarestore.persist.db.postgres.entity.UserEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(@NonNull String username);
}
