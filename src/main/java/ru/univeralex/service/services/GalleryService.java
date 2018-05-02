package ru.univeralex.service.services;

import java.util.List;

public interface GalleryService {
    List<String> getFilenamesForUser(Long userId);
}
