package ru.univeralex.service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.univeralex.service.models.DiaryPage;

import java.util.List;
import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public interface DiaryRepository extends MongoRepository<DiaryPage, Long> {
    List<DiaryPage> findAllByUserIdOrderByDate(Long id);
    Optional<DiaryPage> findFirstByFilename(String filename);
}
