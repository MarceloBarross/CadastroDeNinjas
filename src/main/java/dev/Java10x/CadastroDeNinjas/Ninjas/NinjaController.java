package dev.Java10x.CadastroDeNinjas.Ninjas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @PostMapping("/create")

    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninjaCriado = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Ninja criado com sucesso: " + ninjaCriado.getNome() + " (ID): " + ninjaCriado.getId());
    }
    @GetMapping("/read")
    public ResponseEntity<List<NinjaDTO>> listarTodos(){
        List<NinjaDTO> ninjaDTO = ninjaService.listarTodos();
        return ResponseEntity.ok(ninjaDTO);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<?> listarPorID(@PathVariable Long id){
        NinjaDTO ninjaDTO = ninjaService.listarPorID(id);
        if(ninjaDTO != null){
            return ResponseEntity.ok(ninjaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id " + id + " nao encontrado nos nossos registros");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO data) {

        if (ninjaService.listarPorID(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.alterarNinja(id, data);
            return ResponseEntity.ok(ninjaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " nao encontrado nos nossos registros");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if (ninjaService.listarPorID(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID " + id + " nao encontrado nos nossos registros");
        }
    }
}
