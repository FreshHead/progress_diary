package ru.univeralex.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.univeralex.service.forms.DiaryPageForm;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.repositories.DiaryRepository;
import ru.univeralex.service.transfer.DiaryDto;

import java.util.List;

import static ru.univeralex.service.transfer.DiaryDto.fromList;

/**
 * @author - Alexander Kostarev
 */
@Controller
public class DiaryController {

    @Autowired
    private DiaryRepository diaryRepository;

    @GetMapping("/")
    public String getProfilePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        Sort sortByDate = new Sort(Sort.Direction.ASC, "date");
        List<DiaryDto> diary = fromList(diaryRepository.findAll(sortByDate));
        model.addAttribute("diary", diary);
        return "diary";
    }

    @PostMapping("/new")
    public String addDiaryPage(DiaryPageForm diaryPageForm) {
        DiaryPage newDiaryPage = DiaryPage.from(diaryPageForm);
        diaryRepository.save(newDiaryPage);
        return "redirect:/";
    }
}
