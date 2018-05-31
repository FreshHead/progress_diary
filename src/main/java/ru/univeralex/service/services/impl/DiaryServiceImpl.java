package ru.univeralex.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.univeralex.service.forms.DiaryPageForm;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.models.File;
import ru.univeralex.service.repositories.DiaryRepository;
import ru.univeralex.service.repositories.FilesRepository;
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

    private final FilesRepository filesRepository;

    @Autowired
    public DiaryServiceImpl(DiaryRepository diaryRepository, FilesRepository filesRepository) {
        this.diaryRepository = diaryRepository;
        this.filesRepository = filesRepository;
    }

    @Override
    public void save(DiaryPageForm diaryPageForm, Long userId, MultipartFile[] filesFromUser) {
        Long newPageId = save(diaryPageForm, userId);
        for (MultipartFile file : filesFromUser) {
            File fileModel = File.builder()
                    .filename(file.getOriginalFilename())
                    .data(getDataFromFile(file))
                    .diaryPageId(newPageId)
                    .build();
            filesRepository.save(fileModel);
        }
    }

    @Override
    public long save(DiaryPageForm diaryPageForm, Long userId) {
        DiaryPage newDiaryPage = DiaryPage.from(diaryPageForm, userId);
        return diaryRepository.save(newDiaryPage).getDiaryPageId();
    }

    @Override
    public void delete(Long diary_page_id) {
        filesRepository.deleteAllByDiaryPageId(diary_page_id);
        diaryRepository.delete(diary_page_id);
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
        List<DiaryPageDto> list = fromList(diaryRepository.findAllByUserIdOrderByDate(userId));
        for (DiaryPageDto diaryPageDto : list) {
            List<File> files = filesRepository.findAllByDiaryPageId(diaryPageDto.getDiaryPageId());
            diaryPageDto.setFileNamesFromList(files);
        }
        return list;
    }
}
