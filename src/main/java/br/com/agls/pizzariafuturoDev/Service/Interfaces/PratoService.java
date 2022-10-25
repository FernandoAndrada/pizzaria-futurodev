package br.com.agls.pizzariafuturoDev.Service.Interfaces;

import br.com.agls.pizzariafuturoDev.entity.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface PratoService {

    Prato buscarPorNome(String nome);


    Prato salvar(Prato prato);

    Prato buscar(Long id);

    Prato atualizar(Prato prato);

    void deletar(Long id);

    List<Prato> listar();
}