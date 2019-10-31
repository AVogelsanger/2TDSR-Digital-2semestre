package br.com.fiap.ps.exercicio.controller;

import br.com.fiap.ps.exercicio.model.Prioridade;
import br.com.fiap.ps.exercicio.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("prioridade")
public class PrioridadeController {

    @Autowired
    private PrioridadeRepository prioridadeRepository;

    @PostMapping("excluir")
    public String excluir(int codigo, RedirectAttributes redirect){
        redirect.addFlashAttribute("msg","Exclusão de prioridade realizado com sucesso!");
        prioridadeRepository.deleteById(codigo);
        return "redirect:/prioridade/listar";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("prioridade", prioridadeRepository.findById(codigo));
        return "prioridade/form";
    }

    @GetMapping("listar")
    public String listarPrioridade(Model model){
        model.addAttribute("prioridades", prioridadeRepository.findAll());
        return "prioridade/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Prioridade prioridade){
        return "prioridade/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Prioridade prioridade, RedirectAttributes redirect){
        redirect.addFlashAttribute("msg", "Prioridade cadastrado com sucesso!");
        prioridadeRepository.save(prioridade);
        return "redirect:/prioridade/cadastrar";
    }

}
