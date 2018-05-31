package ru.univeralex.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.univeralex.service.models.File;
import ru.univeralex.service.repositories.FilesRepository;
import ru.univeralex.service.services.ImageService;

/**
 * @author - Alexander Kostarev
 */
@Service
public class ImageServiceImpl implements ImageService {

    private final FilesRepository filesRepository;

    @Autowired
    public ImageServiceImpl(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    @Override
    public byte[] getImageContent(String imageName) {
        File optionalFile = filesRepository.findFirstByFilename(imageName).orElseThrow(IllegalArgumentException::new);
        return optionalFile.getData();
    }
}
