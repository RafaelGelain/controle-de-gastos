package com.despesasPessoal.DespesasPessoal.Categoria;

import com.despesasPessoal.DespesasPessoal.Movimentacao.MovimentacaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {
    private Long id;
    private String nome;
    private TipoCategoria tipoCategoria;
    private List<MovimentacaoModel> movimentacao;
}
