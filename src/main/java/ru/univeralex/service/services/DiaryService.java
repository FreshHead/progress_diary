package ru.univeralex.service.services;

import org.springframework.web.multipart.MultipartFile;
import ru.univeralex.service.forms.DiaryPageForm;
import ru.univeralex.service.transfer.DiaryPageDto;

import java.util.List;

/**
 * @author - Alexander Kostarev
 */
public interface DiaryService {
    void savePage(DiaryPageForm diaryPageForm, Long userId, MultipartFile fileFromUser);

    List<DiaryPageDto> getDiaryForUser(Long userId);
}
