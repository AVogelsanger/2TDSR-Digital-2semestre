package br.com.fiap.aula05.controller;

import br.com.fiap.aula05.model.Cliente;
import br.com.fiap.aula05.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("buscar")
    public String buscar(String termoBusca, Model model){
        model.addAttribute("clientes", clienteRepository.findByNomeContainsOrCpfContains(termoBusca, termoBusca));
        return "cliente/lista";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("clientes", clienteRepository.findAll());
        return "cliente/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Cliente cliente){
        return "cliente/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid Cliente cliente, BindingResult result, RedirectAttributes red){
        if (result.hasErrors()){
            return "cliente/form";
        }
        clienteRepository.save(cliente);
        red.addFlashAttribute("msg", "Cliente cadastrado com sucesso!");
        return "redirect:/cliente/cadastrar";
    }
}
