package br.com.agls.pizzariafuturoDev.Model.Repository;

import br.com.agls.pizzariafuturoDev.Service.Interfaces.CategoriaService;
import br.com.agls.pizzariafuturoDev.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


    //Se existir o nome retorna true
   boolean existsBynome(String nome);//existisByplaca existisBycpf

}







