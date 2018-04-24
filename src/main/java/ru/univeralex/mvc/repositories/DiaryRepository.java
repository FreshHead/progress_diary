package ru.univeralex.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.univeralex.mvc.models.Diary;

/**
 * @author - Alexander Kostarev
 */
public interface DiaryRepository extends JpaRepository<Diary, Long> {
}
