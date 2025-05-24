package com.despesasPessoal.DespesasPessoal.Categoria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity listarPorID(@PathVariable Long id){
        CategoriaDTO categoriaDTO = categoriaService.listarPorID(id);
        if (categoriaDTO != null){
            return ResponseEntity.ok(categoriaDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nao foi encontrado esse ID no Banco");
        }
    }
}
