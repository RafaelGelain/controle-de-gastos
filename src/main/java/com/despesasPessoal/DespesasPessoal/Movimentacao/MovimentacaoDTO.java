package com.despesasPessoal.DespesasPessoal.Movimentacao;

import com.despesasPessoal.DespesasPessoal.Categoria.CategoriaModel;
import com.despesasPessoal.DespesasPessoal.Categoria.TipoCategoria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoDTO {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private TipoCategoria tipo;
    private String observacao;
    private CategoriaModel categoria;


}
