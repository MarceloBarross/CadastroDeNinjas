package dev.Java10x.CadastroDeNinjas.Ninjas;


import dev.Java10x.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaDTO {

    private long id;
    private String nome;
    private int idade;
    private String email;
    private MissoesModel missoes;
    private String rank;
}
