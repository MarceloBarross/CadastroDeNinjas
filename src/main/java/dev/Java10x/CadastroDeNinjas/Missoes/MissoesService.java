package dev.Java10x.CadastroDeNinjas.Missoes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class MissoesService {
    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;

    public MissoesService(MissoesRepository missoesRepository, MissoesMapper missoesMapper){
        this.missoesRepository = missoesRepository;
        this.missoesMapper = missoesMapper;
    }

    public List<MissoesDTO> listarTodos(){
        List<MissoesModel> missoesModel = missoesRepository.findAll();
        List<MissoesDTO> missoesDTOs = missoesModel.stream().map(missoesMapper::map).collect(Collectors.toList());
        return missoesDTOs;
    
    }

    public MissoesDTO listarPorID(Long id){
        Optional<MissoesModel> missoesModel = missoesRepository.findById(id);
        return missoesModel.map(missoesMapper::map).orElse(null);
    }

    public MissoesDTO criarMissao(MissoesDTO missoesDTO){
        MissoesModel missoesModel = missoesMapper.map(missoesDTO);
        missoesModel = missoesRepository.save(missoesModel);
        return missoesMapper.map(missoesModel);
    }

    public void deltarMissao(Long id){
        missoesRepository.deleteById(id);
    }
    public MissoesDTO alterarMissao(Long id, MissoesDTO data){
        Optional<MissoesModel> missaoProcurada = missoesRepository.findById(id);
        if (missaoProcurada.isPresent()) {
            MissoesModel alteracoesMissao = missoesMapper.map(data);
            alteracoesMissao.setId(id);
            MissoesModel missaoAlterada = missoesRepository.save(alteracoesMissao);
            return missoesMapper.map(missaoAlterada);
        } 
        return null;
    }
}
