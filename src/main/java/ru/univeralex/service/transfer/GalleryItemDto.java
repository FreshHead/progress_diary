package ru.univeralex.service.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author - Alexander Kostarev
 */
@Data
@AllArgsConstructor
@Builder
public class GalleryItemDto {
    private Date date;
    private String filename;
    private String note;
}
