package ru.univeralex.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.univeralex.service.models.DiaryPage;
import ru.univeralex.service.repositories.DiaryRepository;
import ru.univeralex.service.security.details.UserDetailsImpl;
import ru.univeralex.service.services.ImageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author - Alexander Kostarev
 */
@Controller
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private ImageService imageService;

    @GetMapping("")
    public String getProfilePage(ModelMap model, Authentication authentication, HttpServletResponse response) {
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Long userId = details.getUser().getUserId();
        List<DiaryPage> diary = diaryRepository.findAllByUserIdOrderByDate(userId);
        List<String> filenames = new ArrayList<>();
        for (DiaryPage diaryPage : diary) {
            if (!diaryPage.getFilename().equals("")) {
                filenames.add(diaryPage.getFilename());
            }
        }
        model.addAttribute("filenames", filenames);
        return "gallery";
    }

    @GetMapping(value = "/imageDisplay")
    public void showImage(@RequestParam("filename") String fileName, HttpServletResponse response, HttpServletRequest request)
            throws ServletException, IOException {

        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(imageService.getImageContent(fileName));

        response.getOutputStream().close();
    }
}
