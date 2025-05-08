package dev.Java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVinadas(){
        return "Boas Vindas";
    }

    @GetMapping("/masvindas")
    public String masVinadas(){
        return "Mas Vindas";
    }
    
}
