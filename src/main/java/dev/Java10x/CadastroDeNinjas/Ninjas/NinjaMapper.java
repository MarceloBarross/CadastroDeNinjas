package dev.Java10x.CadastroDeNinjas.Ninjas;


import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        ninjaModel.setRank(ninjaDTO.getRank());

        return ninjaModel;
    }

    public NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setRank(ninjaModel.getRank());

        return ninjaDTO;
    }
    
}
