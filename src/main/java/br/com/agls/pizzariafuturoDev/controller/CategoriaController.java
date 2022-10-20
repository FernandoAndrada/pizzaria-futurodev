package br.com.agls.pizzariafuturoDev.controller;

//Categoria, 1- Massa , 2- Carne, 3- Petisco, 4- sobre-mesa , 5- suco , 6-refrigerante  ,7-Bebida alcool
// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/
//https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction-to-query-methods/
//validação para não deixar inserir categoria mesmo nome
import br.com.agls.pizzariafuturoDev.Model.Repository.CategoriaRepository;
import br.com.agls.pizzariafuturoDev.Service.Interfaces.CategoriaService;
import br.com.agls.pizzariafuturoDev.entity.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid Categoria categoria) {

//        if(categoriaService.existsBynome(categoria.getNome())){
//
//             return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflit: Nome em uso");
//            }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.categoriaService.salvar(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> atualizar(@RequestBody Categoria categoria) {
        return ResponseEntity.ok(this.categoriaService.atualizar(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        this.categoriaService.deletar(id);
        return ResponseEntity.ok("Excluído com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(this.categoriaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        Categoria categoria = this.categoriaService.buscar(id);

        if(categoria == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.categoriaService.buscar(id));
    }


}
