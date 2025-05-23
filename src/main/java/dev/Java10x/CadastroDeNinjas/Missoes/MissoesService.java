package dev.Java10x.CadastroDeNinjas.Missoes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class MissoesService {
    private MissoesRepository missoesRepository;

    public MissoesService(MissoesRepository missoesRepository){
        this.missoesRepository = missoesRepository;
    }

    public List<MissoesModel> listarTodos(){
        return missoesRepository.findAll();
    }

    public MissoesModel listarPorID(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.orElse(null);
    }

    public MissoesModel criarMissao(MissoesModel missoesModel){
        return missoesRepository.save(missoesModel);
    }

    public void deltarMissao(Long id){
        missoesRepository.deleteById(id);
    }
    public MissoesModel alterarMissao(Long id, MissoesModel data){
        if(missoesRepository.existsById(id)){
            data.setId(id);
            return missoesRepository.save(data);
        }
        return null;
    }
}
