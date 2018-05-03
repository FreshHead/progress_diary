package ru.univeralex.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.univeralex.service.forms.DiaryPageForm;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.repositories.DiaryRepository;
import ru.univeralex.service.services.DiaryService;
import ru.univeralex.service.transfer.DiaryPageDto;

import java.io.IOException;
import java.util.List;

import static ru.univeralex.service.transfer.DiaryPageDto.fromList;

/**
 * @author - Alexander Kostarev
 */
@Service
public class DiaryServiceImpl implements DiaryService {
    private final DiaryRepository diaryRepository;

    @Autowired
    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public void savePage(DiaryPageForm diaryPageForm, Long userId, MultipartFile fileFromUser) {
        byte[] dataFromFile = null;
        try {
            dataFromFile = fileFromUser.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        DiaryPage newDiaryPage = DiaryPage.from(diaryPageForm, userId, fileFromUser.getOriginalFilename(), dataFromFile);
        diaryRepository.save(newDiaryPage);
    }

    @Override
    public List<DiaryPageDto> getDiaryForUser(Long userId) {
        return fromList(diaryRepository.findAllByUserIdOrderByDate(userId));
    }
}
