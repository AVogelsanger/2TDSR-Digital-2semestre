package br.com.fiap.aula06.controller;

import br.com.fiap.aula06.repository.ChamadoRepository;
import br.com.fiap.aula06.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("chamado")
public class ChamadoController {

    @Autowired
    private PrioridadeRepository prioridadeRep;

    @Autowired
    private ChamadoRepository chamadoRep;

}
