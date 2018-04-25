package ru.univeralex.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.univeralex.mvc.repositories.DiaryRepository;

/**
 * @author - Alexander Kostarev
 */
@Controller
public class DiaryController {

    @Autowired
    private DiaryRepository diaryRepository;

    @RequestMapping(path = "/diary", method = RequestMethod.GET)
    public ModelAndView getDiary() {

        ModelAndView modelAndView = new ModelAndView("diary");
        modelAndView.addObject("diary", diaryRepository.findAll());
        return modelAndView;
    }
}
