package dev.Java10x.CadastroDeNinjas.Ninjas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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
    @Operation(summary = "Cria ninja", description = "Esta rota cria ninjas, com nome, idade, email, missoes, rank")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro na criação do ninja"),
        @ApiResponse(responseCode = "500", description = "Possivel duplicidade de dados em campos unicos (email)")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO ninjaCriado = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
        .body("Ninja criado com sucesso: " + ninjaCriado.getNome() + " (ID): " + ninjaCriado.getId());
    }


    @GetMapping("/read")
    @Operation(summary = "Listar todos", description = "Essa rota lista todos os ninjas do banco de dados")
    public ResponseEntity<List<NinjaDTO>> listarTodos(){
        List<NinjaDTO> ninjaDTO = ninjaService.listarTodos();
        return ResponseEntity.ok(ninjaDTO);
    }


    @GetMapping("/read/{id}")
    @Operation(summary = "Listar ninjas por id", description = "Essa rota lista os ninjas usando id como parametro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> listarPorID(@PathVariable Long id){
        NinjaDTO ninjaDTO = ninjaService.listarPorID(id);
        if(ninjaDTO != null){
            return ResponseEntity.ok(ninjaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com id " + id + " nao encontrado nos nossos registros");
        }
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Alterar ninja por id", description = "Altera determinado ninja usando id como parametro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<?> alterarNinja(
        @Parameter(description = "O usuario passa id no caminho da requisição") @PathVariable Long id, 
        @Parameter(description = "O usuario passa os dados do ninja pelo corpo da requisição") @RequestBody NinjaDTO data) {

        if (ninjaService.listarPorID(id) != null) {
            NinjaDTO ninjaDTO = ninjaService.alterarNinja(id, data);
            return ResponseEntity.ok(ninjaDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja com ID " + id + " nao encontrado nos nossos registros");
        }
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deletar ninja por id", description = "Deleta determiado ninja usando o id como parametro")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ninja deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Ninja não encontrado")
    })
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if (ninjaService.listarPorID(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja com o ID " + id + " deletado");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID " + id + " nao encontrado nos nossos registros");
        }
    }
}
