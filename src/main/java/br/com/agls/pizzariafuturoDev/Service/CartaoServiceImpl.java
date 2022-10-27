package br.com.agls.pizzariafuturoDev.Service;

import br.com.agls.pizzariafuturoDev.Model.Repository.CartaoRepository;
import br.com.agls.pizzariafuturoDev.Service.Interfaces.CartaoService;
import br.com.agls.pizzariafuturoDev.entity.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoServiceImpl implements CartaoService {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Override
    public Cartao salvar(Cartao cartao) {
        return this.cartaoRepository.save(cartao);
    }

    @Override
    public Cartao atualizar(Cartao object) {
        return null;
    }

    @Override
    public Cartao buscar(Long id) {
        return null;
    }

    @Override
    public List<Cartao> listar() {
        return null;
    }

    @Override
    public void deletar(Long id) {

    }

    @Override
    public void excluir(Long id) {

    }
}
