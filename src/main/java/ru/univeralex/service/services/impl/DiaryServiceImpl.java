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
    public void save(DiaryPageForm diaryPageForm, Long userId, MultipartFile fileFromUser) {
        DiaryPage newDiaryPage;
        if (diaryPageForm.getId() != null && fileFromUser.getOriginalFilename().isEmpty()) {
            DiaryPage oldDiaryPage = diaryRepository.getOne(diaryPageForm.getId());
            newDiaryPage = DiaryPage.from(diaryPageForm, userId, oldDiaryPage.getFilename(), oldDiaryPage.getData());
        } else if (fileFromUser.getOriginalFilename().isEmpty()) {
            newDiaryPage = DiaryPage.from(diaryPageForm, userId, null, null);
        } else {
            newDiaryPage = DiaryPage.from(diaryPageForm, userId, fileFromUser.getOriginalFilename(), getDataFromFile(fileFromUser));
        }
        diaryRepository.save(newDiaryPage);
    }

    private byte[] getDataFromFile(MultipartFile file) {
        byte[] dataFromFile = null;
        try {
            dataFromFile = file.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFromFile;
    }

    @Override
    public List<DiaryPageDto> getDiaryForUser(Long userId) {
        return fromList(diaryRepository.findAllByUserIdOrderByDate(userId));
    }
}
