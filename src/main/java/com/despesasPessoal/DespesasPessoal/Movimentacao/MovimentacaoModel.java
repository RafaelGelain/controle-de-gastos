package com.despesasPessoal.DespesasPessoal.Movimentacao;

import com.despesasPessoal.DespesasPessoal.Categoria.CategoriaModel;
import com.despesasPessoal.DespesasPessoal.Categoria.TipoCategoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "movimentacao")
@AllArgsConstructor
@NoArgsConstructor
public class MovimentacaoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private TipoCategoria tipo;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoria;
}
