package ru.univeralex.service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.univeralex.service.models.User;

import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public interface UsersRepository extends MongoRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
}
