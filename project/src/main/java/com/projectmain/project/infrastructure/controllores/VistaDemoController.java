package com.projectmain.project.infrastructure.controllores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VistaDemoController {
    @GetMapping("/adimPermisos")
    public String admin(){
        return "admin";
    }
    
}
