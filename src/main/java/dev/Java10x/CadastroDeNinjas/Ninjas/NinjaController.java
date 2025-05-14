package dev.Java10x.CadastroDeNinjas.Ninjas;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @PostMapping("/create")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninjaModel) {
        return ninjaService.criarNinja(ninjaModel);
    }
    @GetMapping("/read")
    public List<NinjaModel> listarTodos(){
        return ninjaService.listarTodos();
    }
    @GetMapping("/read/{id}")
    public NinjaModel listarPorID(@PathVariable Long id){
        return ninjaService.listarPorID(id);
    }
    @PutMapping("/update/{id}")
    public NinjaModel alterarNinja(@PathVariable Long id, @RequestBody NinjaModel data) {
        return ninjaService.alterarNinja(id, data);
    }
    @DeleteMapping("/delete/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }
}
