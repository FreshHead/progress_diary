package ru.univeralex.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.univeralex.service.forms.DiaryPageForm;

import javax.persistence.*;
import java.util.Date;

/**
 * @author - Alexander Kostarev
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "diary_page")
public class DiaryPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_page_id")
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
    @Column(name = "user_id")
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
