package br.com.agls.pizzariafuturoDev.controller;


import br.com.agls.pizzariafuturoDev.Service.Interfaces.CartaoService;
import br.com.agls.pizzariafuturoDev.entity.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    public ResponseEntity<Cartao> salvar(@RequestBody Cartao cartao) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.cartaoService.salvar(cartao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.cartaoService.excluir(id);
        return ResponseEntity.ok("Excluído com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Cartao>> listar() {
        return ResponseEntity.ok(this.cartaoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cartao> buscar(@PathVariable Long id) {
        Cartao cartao = this.cartaoService.buscar(id);

        if(cartao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.cartaoService.buscar(id));
    }


}
