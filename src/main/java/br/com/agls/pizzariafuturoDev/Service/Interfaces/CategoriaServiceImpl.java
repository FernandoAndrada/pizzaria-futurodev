package br.com.agls.pizzariafuturoDev.Service.Interfaces;


import br.com.agls.pizzariafuturoDev.Model.Repository.CategoriaRepository;
import br.com.agls.pizzariafuturoDev.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria salvar(Categoria categoria) {
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

        if (categoria.isPresent()) {
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


}
