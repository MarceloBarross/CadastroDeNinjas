package dev.Java10x.CadastroDeNinjas.Missoes;

import java.util.List;

import dev.Java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {
    
    private long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;
}
