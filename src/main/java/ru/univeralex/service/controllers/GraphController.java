package ru.univeralex.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.univeralex.service.security.details.UserDetailsImpl;
import ru.univeralex.service.services.DiaryService;
import ru.univeralex.service.transfer.DiaryPageDto;

import java.util.List;

/**
 * @author - Alexander Kostarev
 */
@Controller
@RequestMapping("/graph")
public class GraphController {

    private final DiaryService service;

    @Autowired
    public GraphController(DiaryService service) {
        this.service = service;
    }

    @GetMapping("")
    public String getGraph(ModelMap model, Authentication authentication) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = details.getUser().getUserId();
        List<DiaryPageDto> diary = service.getDiaryForUser(userId);
        if (diary.isEmpty()) {
            return "redirect:/diary/new-diary-page";
        }
        model.addAttribute("diary", diary);
        return "graph";
    }
}
