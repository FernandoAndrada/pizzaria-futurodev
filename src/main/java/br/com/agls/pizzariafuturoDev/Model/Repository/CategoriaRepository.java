package br.com.agls.pizzariafuturoDev.Model.Repository;

import br.com.agls.pizzariafuturoDev.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
