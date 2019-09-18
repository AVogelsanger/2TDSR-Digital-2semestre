package br.com.fiap.aula04.controller;

import br.com.fiap.aula04.model.Modalidade;
import br.com.fiap.aula04.repository.ModalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("modalidade")
public class ModalidadeController {

    @Autowired
    private ModalidadeRepository repository;

    @GetMapping("cadastrar")
    public String cadastrar(Modalidade modalidade){
        return "modalidade/form";
    }

    @PostMapping("salvar")
    public String salvar(Modalidade modalidade, RedirectAttributes redirect){
        redirect.addFlashAttribute("msg", "Modalidade cadastrado com sucesso!");
        repository.save(modalidade);
        return "redirect:/modalidade/listar";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("modalidades", repository.findAll());
        return "modalidade/lista";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("modalidade", repository.findById(codigo));
        return "modalidade/form";
    }

    @PostMapping("excluir")
    public String remover(int codigo, RedirectAttributes redirect){
        redirect.addFlashAttribute("msg", "Modalidade excluída com sucesso!");
        repository.deleteById(codigo);
        return "redirect:/modalidade/listar";
    }

}
