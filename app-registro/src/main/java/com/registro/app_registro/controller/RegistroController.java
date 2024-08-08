package com.registro.app_registro.controller;


import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registro")
public class RegistroController {
    
    @GetMapping
    public String registro(ModelMap model) {
        model.addAttribute("title", "User list");
        return "registro";
    }
}
