package org.noctisdev.sciallauthapi.application;


import org.noctisdev.sciallauthapi.domain.models.Contact;
import org.noctisdev.sciallauthapi.domain.models.User;

import java.util.UUID;

public interface IUserService {

    User find(UUID userUuid);
    User create(Contact contact);
    User update(User user);

}
