package br.com.agls.pizzariafuturoDev.Service;

import br.com.agls.pizzariafuturoDev.Model.Repository.ClienteRepository;
import br.com.agls.pizzariafuturoDev.Service.Interfaces.ClienteService;
import br.com.agls.pizzariafuturoDev.entity.Cliente;
import br.com.agls.pizzariafuturoDev.entity.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void excluir(Long id) {
        this.clienteRepository.deleteById(id);
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        Cliente clienteSalva = this.clienteRepository.save(cliente);
        return clienteSalva;
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        Optional<Cliente> clientePesquisada = this.clienteRepository.findById(cliente.getId());

        if(clientePesquisada.isPresent()){
            clientePesquisada.get().setNome(cliente.getNome());
            return this.clienteRepository.save(clientePesquisada.get());
        }
        return null;
    }

    @Override
    public Cliente buscar(Long id) {
        return this.clienteRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("Não foi possível encontrar um cliente com id " + id);
        });
    }

    @Override
    public List<Cliente> listar() {
        return this.clienteRepository.findAll();
    }

    @Override
    public void deletar(Long id) {

    }
}
