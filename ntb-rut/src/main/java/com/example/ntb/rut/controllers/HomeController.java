package com.example.ntb.rut.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class  HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("address", "127994 г. Москва, ул. Образцова д.9 стр.9");
        model.addAttribute("phone", "+7 (495) 274-0274");
        model.addAttribute("email", "ntbrutmiit@yandex.ru");
        return "index";
    }

    @GetMapping("/about")
    public String aboutLibrary() {
        return "about";
    }
}