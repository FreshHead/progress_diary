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
    private Long diary_page_id;
    private Date date;
    private Float neck;
    private Float biceps;
    private Float chest;
    private Float waist;
    private Float hip;
    private Float calf;
    private Float weight;
    private String note;
    private String photo;
    private Long user_id;

    public static DiaryPage from(DiaryPageForm form) {
        return DiaryPage.builder()
                .date(form.getDate())
                .neck(form.getNeck())
                .biceps(form.getBiceps())
                .chest(form.getChest())
                .waist(form.getWaist())
                .hip(form.getHip())
                .calf(form.getCalf())
                .weight(form.getWeight())
                .note(form.getNote())
                .build();
    }
}
