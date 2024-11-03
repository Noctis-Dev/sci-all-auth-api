package org.noctisdev.sciallauthapi.infraestructure.repository.jpa;

import org.noctisdev.sciallauthapi.infraestructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUserUuid(UUID uuid);
}