package ru.univeralex.service.forms;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author - Alexander Kostarev
 */
@Data
public class DiaryPageForm {
    private Long id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Float butt;
    private Float biceps;
    private Float chest;
    private Float waist;
    private Float hip;
    private Float calf;
    private Float weight;
    private String note;
}
