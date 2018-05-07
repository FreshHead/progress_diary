package ru.univeralex.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.univeralex.service.forms.DiaryPageForm;
import ru.univeralex.service.security.details.UserDetailsImpl;
import ru.univeralex.service.services.DiaryService;

/**
 * @author - Alexander Kostarev
 */
@Controller
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryService service;

    @Autowired
    public DiaryController(DiaryService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getDiary(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = details.getUser().getUserId();
        model.addAttribute("diary", service.getDiaryForUser(userId));
        return "archive";
    }

    @GetMapping("/new-diary-page")
    public String getNewPage() {
        return "new-diary-page";
    }

    @PostMapping("/save")
    public String addDiaryPage(@RequestParam("file") MultipartFile fileFromUser,
                               DiaryPageForm diaryPageForm,
                               Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = details.getUser().getUserId();
        service.save(diaryPageForm, userId, fileFromUser);
        return "redirect:/diary";
    }
}
