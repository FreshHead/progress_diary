package ru.univeralex.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.models.File;
import ru.univeralex.service.repositories.DiaryRepository;
import ru.univeralex.service.repositories.FilesRepository;
import ru.univeralex.service.services.GalleryService;
import ru.univeralex.service.transfer.GalleryItemDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - Alexander Kostarev
 */
@Service
public class GalleryServiceImpl implements GalleryService {
    private final DiaryRepository diaryRepository;
    private final FilesRepository filesRepository;

    @Autowired
    public GalleryServiceImpl(DiaryRepository diaryRepository, FilesRepository filesRepository) {
        this.diaryRepository = diaryRepository;
        this.filesRepository = filesRepository;
    }

    @Override
    public List<GalleryItemDto> getGalleryDto(Long userId) {
        List<DiaryPage> diary = diaryRepository.findAllByUserIdOrderByDate(userId);
        List<GalleryItemDto> galleryDto = new ArrayList<>();
        for (DiaryPage diaryPage : diary) {
            List<File> files = filesRepository.findAllByDiaryPageId(diaryPage.getDiaryPageId());
            for (File file : files) {
                galleryDto.add(new GalleryItemDto(diaryPage.getDate(), file.getFilename(), diaryPage.getNote()));

            }
        }
        return galleryDto;
    }
}
