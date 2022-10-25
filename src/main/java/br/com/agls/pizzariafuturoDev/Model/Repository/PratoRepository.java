package br.com.agls.pizzariafuturoDev.Model.Repository;


import br.com.agls.pizzariafuturoDev.entity.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
    Optional<Prato> findByNome(String nome);
}