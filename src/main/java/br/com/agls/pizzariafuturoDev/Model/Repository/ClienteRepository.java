package br.com.agls.pizzariafuturoDev.Model.Repository;


import br.com.agls.pizzariafuturoDev.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> { // long vem do tipo do id



}
