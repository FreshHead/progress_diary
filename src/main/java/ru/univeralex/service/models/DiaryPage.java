package ru.univeralex.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date;
    private Float neck;
    private Float biceps;
    private Float chest;
    private Float waist;
    private Float hip;
    private Float calf;
    private Float weight;
    private String note;
    private String filename;
    private byte[] data;
    @Column(name = "userId")
    private Long userId;

    public static DiaryPage from(DiaryPageForm form, Long userId, String filename, byte[] dataFromFile) {
        return DiaryPage.builder()
                .diaryPageId(form.getDiaryPageId())
                .date(form.getDate())
                .neck(form.getNeck())
                .biceps(form.getBiceps())
                .chest(form.getChest())
                .waist(form.getWaist())
                .hip(form.getHip())
                .calf(form.getCalf())
                .weight(form.getWeight())
                .note(form.getNote())
                .filename(filename)
                .data(dataFromFile)
                .userId(userId)
                .build();
    }
}
