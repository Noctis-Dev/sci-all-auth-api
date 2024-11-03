package org.noctisdev.sciallauthapi.infraestructure.repository.jpa;

import org.noctisdev.sciallauthapi.infraestructure.entities.TokenSettingEntity;
import org.noctisdev.sciallauthapi.infraestructure.entities.enums.TokenTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenSettingEntityRepository extends JpaRepository<TokenSettingEntity, Long> {

    Optional<TokenSettingEntity> findByTokenTypeEntityAndIsActive(TokenTypeEntity type, boolean isActive);

}