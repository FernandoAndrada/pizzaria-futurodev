package br.com.agls.pizzariafuturoDev.Service.Interfaces;

import br.com.agls.pizzariafuturoDev.Model.Repository.CategoriaRepository;
import br.com.agls.pizzariafuturoDev.entity.Categoria;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface CategoriaService extends DefaultCrud<Categoria> {

    Categoria buscarPorNome (String nome);

//    public boolean existsBynome(String nome){
//        return CategoriaRepository.existsBynome(nome);

    }

//    public boolean existsByCategoria(String nome) {
//        return CategoriaRepository.existsByCategoria(nome);
//    }




