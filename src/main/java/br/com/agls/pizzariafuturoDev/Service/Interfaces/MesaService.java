package br.com.agls.pizzariafuturoDev.Service.Interfaces;

import br.com.agls.pizzariafuturoDev.entity.Mesa;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MesaService {

    Mesa salvar(Mesa mesa);

    Mesa atualizar(Mesa mesa);

    Mesa buscar (Long id);

    List<Mesa> listar();

    List<Mesa> listarAtivas();


    void excluir (Long id);


}
