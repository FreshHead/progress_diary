package ru.univeralex.service.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.univeralex.service.models.DiaryPage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author - Alexander Kostarev
 */
@Data
@AllArgsConstructor
@Builder
public class DiaryDto {
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

    public static DiaryDto from(DiaryPage diaryPage) {
        return DiaryDto.builder()
                .date(diaryPage.getDate())
                .neck(diaryPage.getNeck())
                .biceps(diaryPage.getBiceps())
                .chest(diaryPage.getChest())
                .waist(diaryPage.getWaist())
                .hip(diaryPage.getHip())
                .calf(diaryPage.getCalf())
                .weight(diaryPage.getWeight())
                .photo(diaryPage.getPhoto())
                .build();
    }

    public static List<DiaryDto> fromList(List<DiaryPage> diary) {
        List<DiaryDto> dtoList = new ArrayList<>();
        for (DiaryPage page : diary) {
            dtoList.add(from(page));
        }
        return dtoList;
    }
}
