package ru.univeralex.service.services;

import org.springframework.web.multipart.MultipartFile;
import ru.univeralex.service.forms.DiaryPageForm;
import ru.univeralex.service.transfer.DiaryPageDto;

import java.util.List;

/**
 * @author - Alexander Kostarev
 */
public interface DiaryService {
    void save(DiaryPageForm diaryPageForm, Long userId, MultipartFile[] filesFromUser);

    long save(DiaryPageForm diaryPageForm, Long userId);

    void delete(Long diary_page_id);
    List<DiaryPageDto> getDiaryForUser(Long userId);
}
