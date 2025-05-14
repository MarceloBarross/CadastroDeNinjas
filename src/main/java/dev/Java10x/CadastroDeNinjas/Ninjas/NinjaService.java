package dev.Java10x.CadastroDeNinjas.Ninjas;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository=ninjaRepository;
    }

    // Listar todos ninjas
    public List<NinjaModel> listarTodos(){
        return ninjaRepository.findAll();
    }

    //Listar por id
    public NinjaModel listarPorID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    //Salvar novo ninja
    public NinjaModel criarNinja(NinjaModel ninjaModel){
        return ninjaRepository.save(ninjaModel);
    }

    //Deletar ninja
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    //Atualizar ninja
    public NinjaModel alterarNinja(Long id, NinjaModel data){
        if(ninjaRepository.existsById(id)){
            data.setId(id);
            return data;
        }
        return null;
    }
}
