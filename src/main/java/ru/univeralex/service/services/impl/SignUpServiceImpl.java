package ru.univeralex.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.univeralex.service.forms.UserForm;
import ru.univeralex.service.models.Role;
import ru.univeralex.service.models.State;
import ru.univeralex.service.models.User;
import ru.univeralex.service.repositories.UsersRepository;
import ru.univeralex.service.services.SignUpService;

/**
 * 25.04.2018
 * SignUpServiceImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .username(userForm.getUsername())
                .hashPassword(hashPassword)
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepository.save(user);
    }
}
