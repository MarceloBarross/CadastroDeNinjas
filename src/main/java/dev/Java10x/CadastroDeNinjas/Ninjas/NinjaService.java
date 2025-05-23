package dev.Java10x.CadastroDeNinjas.Ninjas;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<NinjaDTO> listarTodos(){
        List<NinjaModel> ninjasModel = ninjaRepository.findAll();
        List<NinjaDTO> ninjasDTO = ninjasModel.stream().map(ninjaMapper::map).collect(Collectors.toList());
        return ninjasDTO;
        
    }

    //Listar por id
    public NinjaDTO listarPorID(Long id){
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.map(ninjaMapper::map).orElse(null);
    }


    //Deletar ninja
    public void deletarNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    //Atualizar ninja
    public NinjaDTO alterarNinja(Long id, NinjaDTO data){
        Optional<NinjaModel> ninjaProcurado = ninjaRepository.findById(id);
        if (ninjaProcurado.isPresent()) {
            NinjaModel atualizacoesNinjaProcurado = ninjaMapper.map(data);
            atualizacoesNinjaProcurado.setId(id);
            NinjaModel ninjaAtualizado = ninjaRepository.save(atualizacoesNinjaProcurado);
            return ninjaMapper.map(ninjaAtualizado);
        }
        return null;
    }
}
