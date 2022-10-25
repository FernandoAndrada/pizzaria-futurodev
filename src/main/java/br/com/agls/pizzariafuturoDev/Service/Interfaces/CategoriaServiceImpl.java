package br.com.agls.pizzariafuturoDev.Service.Interfaces;


import br.com.agls.pizzariafuturoDev.Model.Repository.CategoriaRepository;
import br.com.agls.pizzariafuturoDev.Service.Interfaces.CategoriaService;
import br.com.agls.pizzariafuturoDev.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(Categoria categoria) {

        boolean isNomeExistente = this.categoriaRepository.existsBynome(categoria.getNome().toLowerCase());

        if(isNomeExistente){
            throw new EntityExistsException("Já existe uma categoria com o nome: "+ categoria.getNome());
        }

        return this.categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizar(Categoria categoria) {

        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findById(categoria.getId());

        if(categoriaPesquisada.isPresent()){
            categoriaPesquisada.get().setNome(categoria.getNome());
            return this.categoriaRepository.save(categoriaPesquisada.get());
        }
        return null;
    }

    @Override
    public Categoria buscar(Long id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);

        if (categoria.isEmpty()) {
            return categoria.get();
        }

        return null;
    }



    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    @Override
    public void deletar(Long id) {
        this.categoriaRepository.deleteById(id);

    }


    @Override
    public Categoria buscarPorNome(String nome) {
        Optional<Categoria> categoriaPesquisada = this.categoriaRepository.findByNome(nome);

        if(categoriaPesquisada.isEmpty()) {
            throw new EntityNotFoundException("Não foi possível encontrar uma categoria com o nome: " + nome);
        }

        return categoriaPesquisada.get();
    }
}

//    @Override
//    public boolean existsByCategoria(String nome) {
//        return false;
//    }



