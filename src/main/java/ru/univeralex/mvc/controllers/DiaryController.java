package ru.univeralex.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author - Alexander Kostarev
 */
@Controller
public class DiaryController {

    @RequestMapping(path = "/diary", method = RequestMethod.GET)
    public ModelAndView getDiary() {
        ModelAndView modelAndView = new ModelAndView("diary");
//        modelAndView.addObject("diaryFromServer", users);
        return modelAndView;
    }
}
