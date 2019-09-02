package br.com.fiap.aula03.resource;

import br.com.fiap.aula03.entity.Gravadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import br.com.fiap.aula03.repository.GravadoraRepository;

import java.util.List;

@RestController
@RequestMapping("gravadora")
public class GravadoraResource {

    @Autowired
    private GravadoraRepository rep;

    @GetMapping("internacional")
    public List<Gravadora> pesquisar(@PathVariable boolean internacional){
            return rep.findByInternacional(internacional);
    }// URL - http://localhost:8080/gravadora/internacional=true

    @GetMapping("buscar")
    public List<Gravadora> pesquisar(
            @RequestParam(required = false) String nome,
            @RequestParam(defaultValue = "false") double faturamento){
        if (faturamento != 0)
            return rep.findByNomeContainsAndFaturamentoGreaterThan(nome, faturamento);
        return rep.findByNomeContains(nome);
    }// URL - http://localhost:8080/gravadora/buscar?nome=ZZZ&faturamento=10

    //@GetMapping("buscar")
    //public List<Gravadora> pesquisar(@RequestParam String nome){
        //return rep.findByNomeContains(nome);
    //}  URL - http://localhost:8080/gravadora/buscar?nome=ZZZ


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Gravadora cadastrar(@RequestBody Gravadora gravadora){
        return rep.save(gravadora);
    }

    @GetMapping
    public List<Gravadora> listar(){
        return rep.findAll();
    }

    @PutMapping("{id}")
    public Gravadora alterar(Gravadora gravadora, @PathVariable int id){
        gravadora.setCodigo(id);
        return rep.save(gravadora);
    }

    @DeleteMapping("{codigo}")
    public void remover(@PathVariable int codigo){
        rep.deleteById(codigo);
    }

    @GetMapping("{id}")
    public Gravadora buscar(@PathVariable int id){
        return rep.findById(id).get();
    }
}