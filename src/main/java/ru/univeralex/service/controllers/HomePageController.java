package ru.univeralex.service.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author - Alexander Kostarev
 */
@Controller
public class HomePageController {
    @GetMapping("")
    public String redirect() {
        return "redirect:/diary";
    }
}
