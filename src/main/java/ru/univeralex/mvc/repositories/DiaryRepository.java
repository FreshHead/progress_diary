package ru.univeralex.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.univeralex.mvc.models.DiaryPage;

/**
 * @author - Alexander Kostarev
 */
public interface DiaryRepository extends JpaRepository<DiaryPage, Long> {
}
