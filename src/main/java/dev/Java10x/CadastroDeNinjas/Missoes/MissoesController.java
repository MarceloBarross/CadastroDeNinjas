package dev.Java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarMissao(@RequestBody MissoesDTO missoesDTO) {
        MissoesDTO missaoCriada = missoesService.criarMissao(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Missao " + missaoCriada.getNome() + " com ID " + missaoCriada.getId() + " criada");
    }

    @GetMapping("/read")
    public ResponseEntity<List<MissoesDTO>> mostrarTodasMissoes(){
        List<MissoesDTO> missoesDTOs = missoesService.listarTodos();
        return ResponseEntity.ok(missoesDTOs);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<?> listarPorID(@PathVariable Long id){
        MissoesDTO missoesDTO = missoesService.listarPorID(id);
        if (missoesDTO != null) {
            return ResponseEntity.ok(missoesDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com ID " + id + " nao encontrado nos nossos registros");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> alterarMissao(@PathVariable Long id, @RequestBody MissoesDTO data) {
        if (missoesService.listarPorID(id) != null) {
            MissoesDTO missoesDTO = missoesService.alterarMissao(id, data);
            return ResponseEntity.ok(missoesDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com ID " + id + " nao encontrado nos nossos registros");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deltarMissao(@PathVariable Long id){
        if (missoesService.listarPorID(id) != null) {
            missoesService.deletarMissao(id);
            return ResponseEntity.ok("Missao com ID " + id + " deletada");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missao com id " + id + " nao encontrado nos nossos registros");
        }
    }
    
    
}
