package ru.univeralex.service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author - Alexander Kostarev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    String imageName;
    byte[] imageContent;
}
