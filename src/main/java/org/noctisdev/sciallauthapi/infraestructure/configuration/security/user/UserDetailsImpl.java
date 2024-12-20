package org.noctisdev.sciallauthapi.infraestructure.configuration.security.user;

import lombok.AllArgsConstructor;
import org.noctisdev.sciallauthapi.domain.models.Credential;
import org.noctisdev.sciallauthapi.domain.models.enums.UserStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Credential credential;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.<GrantedAuthority>of(new SimpleGrantedAuthority("ROLE_DEFAULT"));
    }

    @Override
    public String getPassword() {
        return credential.getPassword();
    }

    @Override
    public String getUsername() {
        return credential.getContact().getPhoneNumber();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return credential.getContact().getUser().getStatus().equals(UserStatus.ACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return credential.getVerifiedAt() != null;
    }

    public String getName() {
        return credential.getContact().getEmail();
    }

    public UUID getUserUuid() {
        return credential.getContact().getUser().getUserUuid();
    }
}
