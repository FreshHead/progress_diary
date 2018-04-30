package ru.univeralex.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.univeralex.service.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
//    List<User> findAllByFirstName(String firstName);

    Optional<User> findOneByUsername(String username);
}
