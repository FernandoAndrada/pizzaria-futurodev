package br.com.agls.pizzariafuturoDev.Service.Interfaces;

import br.com.agls.pizzariafuturoDev.entity.Categoria;
import br.com.agls.pizzariafuturoDev.entity.Mesa;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CategoriaService {

    Categoria salvar(Categoria categoria);

    Categoria atualizar(Categoria categoria);

    Categoria buscar (Long id);

    List<Categoria> listar();

    void deletar (Long id);
}
