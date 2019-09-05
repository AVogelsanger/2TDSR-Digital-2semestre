package br.com.fiap.aula03.controller;


import br.com.fiap.aula03.entity.Gravadora;
import br.com.fiap.aula03.repository.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("gravadora")
public class GravadoraController {

    @Autowired
    private GravadoraRepository rep;

    @PostMapping("excluir")
    public String remover(int codigo, RedirectAttributes redirect){
        rep.deleteById(codigo);
        redirect.addFlashAttribute("msg", "Gravadora excluída com sucesso!");
        return "redirect:/gravadora/listar";
    }

    @PostMapping("editar")
    public String editar(Gravadora gravadora, RedirectAttributes redirect){
        rep.save(gravadora);
        redirect.addFlashAttribute("msg", "Gravadora atualizado com sucesso!");
        return "redirect:/gravadora/listar"; //URL
    }

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") int codigo, Model model){
        model.addAttribute("gravadora", rep.findById(codigo));
        return "gravadora/edicao";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("gravadoras", rep.findAll());
        return "gravadora/lista";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Gravadora gravadora, Model model){

        rep.save(gravadora); //cadastrar/salvar a gravadora no banco de dados
        model.addAttribute("msg", "Gravadora cadastrada com sucesso!"); //mandar uma msg para a tela
        return "gravadora/form"; //retornar a página
    }

    @GetMapping("cadastrar")
    public String cadastrar(Gravadora gravadora){
        return "gravadora/form";
    }

}
