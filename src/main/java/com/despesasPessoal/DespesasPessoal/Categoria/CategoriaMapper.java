package com.despesasPessoal.DespesasPessoal.Categoria;

import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {
    public CategoriaModel map(CategoriaDTO categoriaDTO){
        CategoriaModel categoriaModel = new CategoriaModel();
        categoriaModel.setId(categoriaDTO.getId());
        categoriaModel.setTipoCategoria(categoriaDTO.getTipoCategoria());
        categoriaModel.setNome(categoriaDTO.getNome());
        categoriaModel.setMovimentacao(categoriaDTO.getMovimentacao());
        return categoriaModel;
    }

    public CategoriaDTO map(CategoriaModel categoriaModel){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoriaModel.getId());
        categoriaDTO.setTipoCategoria(categoriaModel.getTipoCategoria());
        categoriaDTO.setMovimentacao(categoriaModel.getMovimentacao());
        categoriaDTO.setNome(categoriaModel.getNome());
        return categoriaDTO;
    }
}
