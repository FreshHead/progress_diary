package ru.univeralex.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author - Alexander Kostarev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class File {
    private Long fileId;
    private String filename;
    private byte[] data;
    private Long diaryPageId;

}
