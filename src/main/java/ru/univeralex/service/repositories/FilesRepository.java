package ru.univeralex.service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.univeralex.service.models.File;

import java.util.List;
import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public interface FilesRepository extends MongoRepository<File, Long> {
    List<File> findAllByDiaryPageId(Long diaryPageId);

    Optional<File> findFirstByFilename(String filename);

    void deleteAllByDiaryPageId(Long id);
}
