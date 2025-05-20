package dev.Java10x.CadastroDeNinjas.Ninjas;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {
    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper){
        this.ninjaRepository=ninjaRepository;
        this.ninjaMapper=ninjaMapper;
    }

    //Salvar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
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


    //Deletar ninja
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    //Atualizar ninja
    public NinjaModel alterarNinja(Long id, NinjaModel data){
        if(ninjaRepository.existsById(id)){
            data.setId(id);

            return ninjaRepository.save(data);
        }
        return null;
    }
}
