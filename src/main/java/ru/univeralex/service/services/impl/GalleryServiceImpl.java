package ru.univeralex.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.repositories.DiaryRepository;
import ru.univeralex.service.services.GalleryService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author - Alexander Kostarev
 */
@Service
public class GalleryServiceImpl implements GalleryService {
    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public List<String> getFilenamesForUser(Long userId) {
        List<DiaryPage> diary = diaryRepository.findAllByUserIdOrderByDate(userId);
        List<String> filenames = new ArrayList<>();
        for (DiaryPage diaryPage : diary) {
            if (!diaryPage.getFilename().equals("")) {
                filenames.add(diaryPage.getFilename());
            }
        }
        return filenames;
    }
}
