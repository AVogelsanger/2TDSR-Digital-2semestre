package br.com.fiap.aula05.controller;

import br.com.fiap.aula05.model.Cliente;
import br.com.fiap.aula05.model.Pedido;
import br.com.fiap.aula05.repository.ClienteRepository;
import br.com.fiap.aula05.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("cadastrar/{id}")
    public String cadastrar(@PathVariable("id") int codigo, Model model, Pedido pedido){
        Cliente cliente = clienteRepository.findById(codigo).get();
        pedido.setCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "pedido/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid Pedido pedido, BindingResult result, Model model, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            Cliente cliente = clienteRepository.findById(pedido.getCliente().getCodigo()).get();
            model.addAttribute("cliente", cliente);
            return "pedido/form";
        }
        pedidoRepository.save(pedido);
        redirectAttributes.addFlashAttribute("msg", "Pedido registrado!");
        return "redirect:/pedido/cadastrar";
    }

}
