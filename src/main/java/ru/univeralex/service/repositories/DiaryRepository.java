package ru.univeralex.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.univeralex.service.models.DiaryPage;

import java.util.List;
import java.util.Optional;

/**
 * @author - Alexander Kostarev
 */
public interface DiaryRepository extends JpaRepository<DiaryPage, Long> {
    List<DiaryPage> findAllByUserIdOrderByDate(Long id);

    Optional<DiaryPage> findByFilename(String filename);
}
