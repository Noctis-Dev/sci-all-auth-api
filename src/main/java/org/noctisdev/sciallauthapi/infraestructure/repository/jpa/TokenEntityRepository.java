package org.noctisdev.sciallauthapi.infraestructure.repository.jpa;

import org.noctisdev.sciallauthapi.infraestructure.entities.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenEntityRepository extends JpaRepository<TokenEntity, Long> {

    Optional<TokenEntity> findByToken(String token);

}