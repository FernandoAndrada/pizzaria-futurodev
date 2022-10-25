package br.com.agls.pizzariafuturoDev.controller;


import br.com.agls.pizzariafuturoDev.Service.Interfaces.PratoService;
import br.com.agls.pizzariafuturoDev.entity.Mesa;
import br.com.agls.pizzariafuturoDev.entity.Prato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/pratos")
public class PratoController {
    @Autowired
    private PratoService pratoService;

    @PutMapping
    public ResponseEntity<Prato> atualizar(@RequestBody Prato prato) {
        return ResponseEntity.ok(this.pratoService.atualizar(prato));
    }


    @PostMapping
    public ResponseEntity<Prato> salvar(@RequestBody Prato prato) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.pratoService.salvar(prato));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prato> buscar(@PathVariable Long id){
        Prato prato = this.pratoService.buscar(id);

        if(prato == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.pratoService.buscar(id));
    }

    @GetMapping("/buscar-por-nome")
    public ResponseEntity<Prato> buscarPorNome(@PathParam("nome") String nome) {
        return ResponseEntity.ok(this.pratoService.buscarPorNome(nome));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        this.pratoService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Prato>> listar() {
        return ResponseEntity.ok(this.pratoService.listar());
    }

}
