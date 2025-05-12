package dev.Java10x.CadastroDeNinjas.Ninjas;

import java.util.List;

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
}
