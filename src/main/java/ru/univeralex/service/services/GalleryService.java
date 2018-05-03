package ru.univeralex.service.services;

import ru.univeralex.service.transfer.GalleryItemDto;

import java.util.List;

public interface GalleryService {
    List<GalleryItemDto> getGalleryDto(Long userId);
}
