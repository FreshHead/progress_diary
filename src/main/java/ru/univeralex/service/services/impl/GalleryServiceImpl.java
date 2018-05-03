package ru.univeralex.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.repositories.DiaryRepository;
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

    @Autowired
    public GalleryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public List<GalleryItemDto> getGalleryDto(Long userId) {
        List<DiaryPage> diary = diaryRepository.findAllByUserIdOrderByDate(userId);
        List<GalleryItemDto> galleryDto = new ArrayList<>();
        for (DiaryPage diaryPage : diary) {
            if (!diaryPage.getFilename().equals("")) {
                galleryDto.add(new GalleryItemDto(diaryPage.getDate(), diaryPage.getFilename(), diaryPage.getNote()));
            }
        }
        return galleryDto;
    }
}
