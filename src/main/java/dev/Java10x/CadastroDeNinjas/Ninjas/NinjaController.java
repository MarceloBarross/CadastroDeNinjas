package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVinadas(){
        return "Boas Vindas";
    }

    @PostMapping("/create")
    public String criarNinja() {
        return "Criar";
    }
    @GetMapping("/read")
    public String mostrarTodosNinjas(){
        return "Mostrar todos";
    }
    @GetMapping("/readID")
    public String mostrarNinjaPorID(){
        return "Mostrar por ID";
    }
    @PutMapping("/update")
    public String alterarNinja() {
        return "Alterar";
    }
    @DeleteMapping("/delete")
    public String deltarNinja(){
        return "Deletar";
    }
    
    
}
