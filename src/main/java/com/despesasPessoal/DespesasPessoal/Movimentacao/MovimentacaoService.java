package com.despesasPessoal.DespesasPessoal.Movimentacao;


import com.despesasPessoal.DespesasPessoal.Categoria.CategoriaModel;
import com.despesasPessoal.DespesasPessoal.Categoria.CategoriaRepository;
import com.despesasPessoal.DespesasPessoal.Categoria.TipoCategoria;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimentacaoService {
    private final MovimentacaoMapper movimentacaoMapper;
    private final MovimentacaoRepository movimentacaoRepository;
    private final CategoriaRepository categoriaRepository;

    public MovimentacaoService(MovimentacaoMapper movimentacaoMapper, MovimentacaoRepository movimentacaoRepository, CategoriaRepository categoriaRepository) {
        this.movimentacaoMapper = movimentacaoMapper;
        this.movimentacaoRepository = movimentacaoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<MovimentacaoDTO> movimentacaoListar (){
        List<MovimentacaoModel> listarMov = movimentacaoRepository.findAll();
        return listarMov.stream().map(movimentacaoMapper::map).collect(Collectors.toList());
    }
    public MovimentacaoDTO movimentacaoPorID(Long id){
        Optional<MovimentacaoModel> listarPorID = movimentacaoRepository.findById(id);
        return listarPorID.map(movimentacaoMapper::map).orElse(null);
    }
    public MovimentacaoDTO movimentacaoCriar(MovimentacaoDTO movimentacaoDTO){
        MovimentacaoModel movimentacao = movimentacaoMapper.map(movimentacaoDTO);
        movimentacao = movimentacaoRepository.save(movimentacao);
        return movimentacaoMapper.map(movimentacao);
    }

    public MovimentacaoDTO movimentacaoAtualizar(Long id, MovimentacaoDTO movimentacaoDTO){
        Optional<MovimentacaoModel> movimentacao = movimentacaoRepository.findById(id);
        if (movimentacao.isPresent()){
            MovimentacaoModel movimentacaoAtualizada = movimentacaoMapper.map(movimentacaoDTO);
            movimentacaoAtualizada.setId(id);
            MovimentacaoModel movimentacaoSalvar = movimentacaoRepository.save(movimentacaoAtualizada);
            return movimentacaoMapper.map(movimentacaoSalvar);
        }else {
            return null;
        }
    }

    public void movimentacaoDeletar(Long id){
        movimentacaoRepository.deleteById(id);
    }

    public List<MovimentacaoDTO> movimentacaoFiltrarPorTipo(TipoCategoria tipo){
        List<MovimentacaoModel> movimentacao = movimentacaoRepository.findByTipo(tipo);
        return movimentacao.stream().map(movimentacaoMapper::map).collect(Collectors.toList());
    }

    public List<MovimentacaoDTO> movimentacaoFiltrarPorCategoria(Long idCategoria){
        Optional<CategoriaModel> categoriaModel = categoriaRepository.findById(idCategoria);
        if (categoriaModel.isPresent()){
            List<MovimentacaoModel> movimentacao = movimentacaoRepository.findByCategoria(categoriaModel.get());
            return movimentacao.stream().map(movimentacaoMapper::map).collect(Collectors.toList());
        }else {
            return null;
        }
    }

    public List<MovimentacaoDTO> movimentacaoFiltrarPorData(LocalDate dateInicial,LocalDate dataFinal){
        List<MovimentacaoModel> movimentacao = movimentacaoRepository.findByDataBetween(dataFinal,dataFinal);
        return movimentacao.stream().map(movimentacaoMapper::map).collect(Collectors.toList());
    }
    //CONSULTAR SALDO TOTAL ( DECEITAS - DESPESAS )
    public BigDecimal movimentacaoSaldoTotal(){
        List<MovimentacaoModel> movimentacao = movimentacaoRepository.findAll();
            BigDecimal valorReceitas = movimentacao.stream().filter(m -> m.getTipo() == TipoCategoria.RECEITA).map(MovimentacaoModel::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal valorDespesas = movimentacao.stream().filter(m -> m.getTipo() == TipoCategoria.DESPESA).map(MovimentacaoModel::getValor).reduce(BigDecimal.ZERO,BigDecimal::add);

            return valorReceitas.subtract(valorDespesas);

    }
}
