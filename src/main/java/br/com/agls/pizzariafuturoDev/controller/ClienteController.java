package br.com.agls.pizzariafuturoDev.controller;

import br.com.agls.pizzariafuturoDev.Service.Interfaces.ClienteService;
import br.com.agls.pizzariafuturoDev.dto.CartaoRequestDto;
import br.com.agls.pizzariafuturoDev.dto.ClienteRequestDto;
import br.com.agls.pizzariafuturoDev.entity.Cartao;
import br.com.agls.pizzariafuturoDev.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid ClienteRequestDto clienteDto) {
        Cliente cliente = parseToCliente(clienteDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.clienteService.salvar(cliente));
    }
    @PutMapping
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(this.clienteService.atualizar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.clienteService.excluir(id);
        return ResponseEntity.ok("Excluído com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {
        return ResponseEntity.ok(this.clienteService.listar());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(this.clienteService.buscar(id));
    }
    private Cliente parseToCliente(ClienteRequestDto clienteDto) {
        Cliente cliente = Cliente.builder().nome(clienteDto.getNome()).build();
        List<Cartao> cartoes = new ArrayList<Cartao>();

        if (!clienteDto.getCartoes().isEmpty()) {
            for (CartaoRequestDto cartaoDto : clienteDto.getCartoes()) {
                Cartao novoCartao = Cartao.builder()
                        .numero(cartaoDto.getNumero())
                        .validade(cartaoDto.getValidade())
                        .limite(cartaoDto.getLimite())
                        .tipoCartao(cartaoDto.getTipoCartao())
                        .cliente(cliente)
                        .build();

                cartoes.add(novoCartao);
            }
        }
        cliente.setCartoes(cartoes);
        return cliente;
    }

}
