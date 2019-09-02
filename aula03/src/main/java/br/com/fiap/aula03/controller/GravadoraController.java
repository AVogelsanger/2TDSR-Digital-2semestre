package br.com.fiap.aula03.controller;


import br.com.fiap.aula03.entity.Gravadora;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("gravadora")
public class GravadoraController {

    @GetMapping("cadastrar")
    public String cadastrar(){
        return "gravadora/form";
    }

}
