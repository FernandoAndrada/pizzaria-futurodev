package br.com.agls.pizzariafuturoDev.Service;

import br.com.agls.pizzariafuturoDev.Model.Repository.MesaRepository;
import br.com.agls.pizzariafuturoDev.Service.Interfaces.MesaService;
import br.com.agls.pizzariafuturoDev.entity.Mesa;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MesaServiceImpl implements MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public Mesa salvar(Mesa mesa) {
        Mesa mesaSalva = this.mesaRepository.save(mesa);
        return mesaSalva;
    }

    @Override
    public Mesa atualizar(Mesa mesa) {
        Optional<Mesa> mesaPesquisada = this.mesaRepository.findById(mesa.getId());

        if(mesaPesquisada.isPresent()){
            mesaPesquisada.get().setStatus(mesa.getStatus());
            //BeanUtils.copyProperties(mesa, mesaPesquisada.get(),"id","status");
            return this.mesaRepository.save(mesaPesquisada.get());
        }
        return null;
    }

    @Override
    public Mesa buscar(Long id) {
        return this.mesaRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar uma mesa com id " + id);
        });
    }

    @Override
    public List<Mesa> listar() {
        return this.mesaRepository.findAll();
    }


    @Override
    public List<Mesa> listarAtivas(){

        List<Mesa> mesas = this.mesaRepository.findAll();
        List<Mesa> mesasAtivas = new ArrayList<>();

//          List<Mesa> mesas = this.mesaRepository.findAll()
//                .stream()
//                .filter(mesa -> mesa.getStatus() == true)
//                .collect(Collectors.toList());

//        mesas.forEach(mesa -> {
//            if(mesa.getStatus() == true) {
//                mesasAtivas.add(mesa);
//            }
//        });

        for(int i = 0; i < mesas.size();i++) {
            if(mesas.get(i).getStatus() == true) {
                mesasAtivas.add(mesas.get(i));
            }
        }

        return mesasAtivas;
    }


    @Override
    public void excluir(Long id) {
        this.buscar(id);
        //delete from mesa where id = :id;
        this.mesaRepository.deleteById(id);
    }


}
