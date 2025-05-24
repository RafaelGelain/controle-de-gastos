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
    public CategoriaDTO criarServico (CategoriaDTO categoriaDTO){
        CategoriaModel categoriaModel = categoriaMapper.map(categoriaDTO);
        categoriaModel = categoriaRepository.save(categoriaModel);
        return categoriaMapper.map(categoriaModel);
    }
    //ATUALIZAR
    public CategoriaDTO atualizarServico (Long id, CategoriaDTO categoriaDTO){
        Optional<CategoriaModel> categoriaModel = categoriaRepository.findById(id);
        if (categoriaModel.isPresent()){
            CategoriaModel atualizarCategoria = categoriaMapper.map(categoriaDTO);
            atualizarCategoria.setId(id);
            CategoriaModel categoriaSalva = categoriaRepository.save(atualizarCategoria);
            return categoriaMapper.map(categoriaSalva);
        }else {
            return null;
        }
    }

    //DELETAR
    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
