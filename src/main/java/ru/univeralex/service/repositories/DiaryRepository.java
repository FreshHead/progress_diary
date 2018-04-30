package ru.univeralex.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.univeralex.service.models.DiaryPage;

/**
 * @author - Alexander Kostarev
 */
public interface DiaryRepository extends JpaRepository<DiaryPage, Long> {
}
