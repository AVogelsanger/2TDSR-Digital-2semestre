package br.com.fiap.aula06.controller;

import br.com.fiap.aula06.model.Prioridade;
import br.com.fiap.aula06.repository.ChamadoRepository;
import br.com.fiap.aula06.repository.PrioridadeRepository;
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
    private PrioridadeRepository prioridadeRep;

    @Autowired
    private ChamadoRepository chamadoRep;

    @GetMapping("cadastrar")
    public String cadastrar(Prioridade prioridade, Model model){
        model.addAttribute("chamados", chamadoRep.findAll());
        return "prioridade/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Prioridade prioridade, RedirectAttributes redirect){
        redirect.addFlashAttribute("msg", "Prioridade cadastrado com sucesso!");
        prioridadeRep.save(prioridade);
        return "redirect:/prioridade/cadastrar";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("prioridades", prioridadeRep.findAll());
        return "prioridade/lista";
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("prioridade", prioridadeRep.findById(codigo));
        return "prioridade/lista";
    }

    @PostMapping("excluir")
    public String remover(int codigo, RedirectAttributes redirect){
        redirect.addFlashAttribute("msg", "Prioridade excluída com sucesso!");
        prioridadeRep.deleteById(codigo);
        return "redirect:/prioridade/listar";
    }

}
