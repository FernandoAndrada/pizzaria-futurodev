package br.com.agls.pizzariafuturoDev.Service;

import br.com.agls.pizzariafuturoDev.Model.Repository.MesaRepository;
import br.com.agls.pizzariafuturoDev.Service.Interfaces.MesaService;
import br.com.agls.pizzariafuturoDev.entity.Mesa;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Optional<Mesa> mesa =this.mesaRepository.findById(id);

        if(mesa.isPresent()) {
            return mesa.get();
        }

        return null;
    }

    @Override
    public List<Mesa> listar() {
        return this.mesaRepository.findAll();
    }


    @Override
    public List<Mesa> listarAtivas(){
        return null;
    }

    @Override
    public void excluir(Long id) {
        this.mesaRepository.deleteById(id);
    }


}
