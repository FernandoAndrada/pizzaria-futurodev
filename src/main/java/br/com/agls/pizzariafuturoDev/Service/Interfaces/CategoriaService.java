package br.com.agls.pizzariafuturoDev.Service.Interfaces;

import br.com.agls.pizzariafuturoDev.Model.Repository.CategoriaRepository;
import br.com.agls.pizzariafuturoDev.entity.Categoria;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public interface CategoriaService {

    Categoria salvar(Categoria categoria);

    Categoria atualizar(Categoria categoria);

    Categoria buscar(Long id);

    List<Categoria> listar();

    void deletar(Long id);

//    public boolean existsBynome(String nome){
//        return CategoriaRepository.existsBynome(nome);

    }

//    public boolean existsByCategoria(String nome) {
//        return CategoriaRepository.existsByCategoria(nome);
//    }




