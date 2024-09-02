package com.projectmain.project.infrastructure.controllores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaNoPermisos {
    @GetMapping("/adimPermisos/sinPermisos")
    public String paginaRegistro(){
        return "paginaRegistro";
    }
}
