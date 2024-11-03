package org.noctisdev.sciallauthapi.infraestructure.configuration.security.user;

import org.noctisdev.sciallauthapi.application.ICredentialService;
import org.noctisdev.sciallauthapi.domain.models.Credential;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ICredentialService repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential credential = repository.find(username);
        return new UserDetailsImpl(credential);
    }
}
