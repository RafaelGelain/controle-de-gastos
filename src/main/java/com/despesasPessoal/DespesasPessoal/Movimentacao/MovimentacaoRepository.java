package com.despesasPessoal.DespesasPessoal.Movimentacao;

import com.despesasPessoal.DespesasPessoal.Categoria.CategoriaModel;
import com.despesasPessoal.DespesasPessoal.Categoria.TipoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<MovimentacaoModel, Long> {
    List<MovimentacaoModel> findByTipo(TipoCategoria tipo);
    List<MovimentacaoModel> findByDataBetween(LocalDate dataInicio, LocalDate dataFim);
    List<MovimentacaoModel> findByCategoria(CategoriaModel categoria);
}
