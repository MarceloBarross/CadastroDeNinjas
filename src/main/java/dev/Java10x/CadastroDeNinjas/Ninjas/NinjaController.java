package dev.Java10x.CadastroDeNinjas.Ninjas;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @PostMapping("/create")
    public String criarNinja() {
        return "Criar";
    }
    @GetMapping("/read")
    public List<NinjaModel> mostrarTodosNinjas(){
        return ninjaService.listarTodos();
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
