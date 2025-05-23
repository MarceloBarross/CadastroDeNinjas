package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("missoes")
public class MissoesController {

    private MissoesService missoesService;

    public MissoesController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @PostMapping("/create")
    public MissoesModel criarMissao(@RequestBody MissoesModel missoesModel) {
        return missoesService.criarMissao(missoesModel);
    }
    @GetMapping("/read")
    public List<MissoesModel> mostrarTodasMissoes(){
        return missoesService.listarTodos();
    }
    @GetMapping("/read/{id}")
    public MissoesModel listarPorID(@PathVariable Long id){
        return missoesService.listarPorID(id);
    }
    @PutMapping("/update/{id}")
    public MissoesModel alterarMissao(@PathVariable Long id, @RequestBody MissoesModel data) {
        return missoesService.alterarMissao(id, data);
    }
    @DeleteMapping("/delete/{id}")
    public void deltarMissao(@PathVariable Long id){
        missoesService.deltarMissao(id);
    }
    
    
}
