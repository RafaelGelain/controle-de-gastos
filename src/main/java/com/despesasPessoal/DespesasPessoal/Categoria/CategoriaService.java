package com.despesasPessoal.DespesasPessoal.Categoria;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;
    private CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    //LISTAR
    public List<CategoriaDTO> listarCategorias(){
        List<CategoriaModel> listarCategoria = categoriaRepository.findAll();
        return listarCategoria.stream().map(categoriaMapper::map).collect(Collectors.toList());
    }

    //LISTAR POR ID
    public CategoriaDTO listarPorID(Long id){
        Optional<CategoriaModel> listarID = categoriaRepository.findById(id);
        return listarID.map(categoriaMapper::map).orElse(null);
        }

    //CRIAR

    //ATUALIZAR

    //DELETAR

}
