package ru.univeralex.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.univeralex.service.models.User;

import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
}
