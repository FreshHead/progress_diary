package ru.univeralex.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.univeralex.service.forms.DiaryPageForm;

import java.util.Date;

/**
 * @author - Alexander Kostarev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryPage {
    private Long diaryPageId;
    private Date date;
    private Float butt;
    private Float biceps;
    private Float chest;
    private Float waist;
    private Float hip;
    private Float calf;
    private Float weight;
    private String note;
    private String filename;
    private byte[] data;
    private Long userId;

    public static DiaryPage from(DiaryPageForm form, Long userId) {
        return DiaryPage.builder()
                .diaryPageId(form.getDiary_page_id())
                .date(form.getDate())
                .butt(form.getButt())
                .biceps(form.getBiceps())
                .chest(form.getChest())
                .waist(form.getWaist())
                .hip(form.getHip())
                .calf(form.getCalf())
                .weight(form.getWeight())
                .note(form.getNote())
                .userId(userId)
                .build();
    }
}
