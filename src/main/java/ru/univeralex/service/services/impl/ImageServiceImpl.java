package ru.univeralex.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.repositories.DiaryRepository;
import ru.univeralex.service.services.ImageService;

/**
 * @author - Alexander Kostarev
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private DiaryRepository diaryRepository;

    @Override
    public byte[] getImageContent(String imageName) {
        DiaryPage optionalDiaryPage = diaryRepository.findFirstByFilename(imageName).orElseThrow(IllegalArgumentException::new);
        return optionalDiaryPage.getData();
    }
}
