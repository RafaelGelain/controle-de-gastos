package com.despesasPessoal.DespesasPessoal.Categoria;

import com.despesasPessoal.DespesasPessoal.Movimentacao.MovimentacaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table (name = "categoria")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoCategoria tipoCategoria;

    @OneToMany(mappedBy = "categoria")
    private List<MovimentacaoModel> movimentacao;
}
