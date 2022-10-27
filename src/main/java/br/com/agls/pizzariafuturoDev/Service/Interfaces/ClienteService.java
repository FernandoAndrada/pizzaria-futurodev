package br.com.agls.pizzariafuturoDev.Service.Interfaces;


import br.com.agls.pizzariafuturoDev.entity.Cliente;
import org.springframework.stereotype.Service;

@Service
public interface ClienteService extends DefaultCrud<Cliente> {

    void excluir(Long id);
}
