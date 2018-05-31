package ru.univeralex.service.transfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.models.File;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author - Alexander Kostarev
 */
@Data
@AllArgsConstructor
@Builder
public class DiaryPageDto {
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
    private List<String> filenames;

    private static DiaryPageDto from(DiaryPage diaryPage) {
        return DiaryPageDto.builder()
                .diaryPageId(diaryPage.getDiaryPageId())
                .date(diaryPage.getDate())
                .butt(diaryPage.getButt())
                .biceps(diaryPage.getBiceps())
                .chest(diaryPage.getChest())
                .waist(diaryPage.getWaist())
                .hip(diaryPage.getHip())
                .calf(diaryPage.getCalf())
                .weight(diaryPage.getWeight())
                .note(diaryPage.getNote())
                .build();
    }

    public String getDateStringForInput() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(this.date);
    }

    public String getDateStringForJS() {
        DateFormat dateFormat = new SimpleDateFormat();
        return dateFormat.format(this.date);
    }

    public static List<DiaryPageDto> fromList(List<DiaryPage> diary) {
        List<DiaryPageDto> dtoList = new ArrayList<>();
        for (DiaryPage page : diary) {
            dtoList.add(from(page));
        }
        return dtoList;
    }

    public void setFileNamesFromList(List<File> files) {
        this.filenames = new ArrayList<>();
        for (File file : files) {
            this.filenames.add(file.getFilename());
        }
    }
}
