package com.despesasPessoal.DespesasPessoal.Categoria;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaDTO>> listarCategorias(){
        List<CategoriaDTO> listarCategoria = categoriaService.listarCategorias();
        return ResponseEntity.ok(listarCategoria);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorID(@PathVariable Long id){
        CategoriaDTO categoriaDTO = categoriaService.listarPorID(id);
        if (categoriaDTO != null){
            return ResponseEntity.ok(categoriaDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao foi encontrado esse ID no Banco");
        }
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarCategoria(@RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoriaCriar = categoriaService.criarServico(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Criado com Sucesso.");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoria = categoriaService.atualizarServico(id, categoriaDTO);
        if (categoria != null){
            return ResponseEntity.ok(categoria);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("a categoria com ID "+id+" nao foi encontrada para realizar a alteracao");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
        if (categoriaService.listarPorID(id) != null) {
            categoriaService.deletarCategoria(id);
            return ResponseEntity.ok("deletado");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("a categoria com o ID "+id+" nao foi encontrada, verifique se esta correto");
        }
    }
}
