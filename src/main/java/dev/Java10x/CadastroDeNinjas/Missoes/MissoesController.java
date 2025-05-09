package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/create")
    public String criarMissao() {
        return "Criar";
    }
    @GetMapping("/read")
    public String mostrarTodasMissoes(){
        return "Mostrar todos";
    }
    @GetMapping("/readID")
    public String mostrarMissaoPorID(){
        return "Mostrar por ID";
    }
    @PutMapping("/update")
    public String alterarMissao() {
        return "Alterar";
    }
    @DeleteMapping("/delete")
    public String deltarMissao(){
        return "Deletar";
    }
    
    
}
