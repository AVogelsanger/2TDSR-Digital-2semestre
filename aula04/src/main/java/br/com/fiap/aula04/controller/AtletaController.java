package br.com.fiap.aula04.controller;

import br.com.fiap.aula04.model.Atleta;
import br.com.fiap.aula04.repository.AtletaRepository;
import br.com.fiap.aula04.repository.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("atleta")
public class AtletaController {

    @Autowired
    private AtletaRepository atltetaRep;

    @Autowired
    private ModalidadeRepository modalidadeRep;

    @GetMapping("buscar")
    public String buscar(String nomeBusca, Model model){
        model.addAttribute("atletas", atltetaRep.findByNomeContainsIgnoreCase(nomeBusca));
        return "atleta/lista";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("atletas", atltetaRep.findAll());
        return "atleta/lista";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Atleta atleta, RedirectAttributes redirect){
        atltetaRep.save(atleta);
        redirect.addFlashAttribute("msg", "Atleta cadastrado com sucesso!");
        return "redirect:/atleta/cadastrar";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Atleta atleta, Model model){
        model.addAttribute("modalidades", modalidadeRep.findAll());
        return "atleta/form";
    }
}
