package com.despesasPessoal.DespesasPessoal.Movimentacao;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovimentacaoService {
    private final MovimentacaoMapper movimentacaoMapper;
    private final MovimentacaoRepository movimentacaoRepository;

    public MovimentacaoService(MovimentacaoMapper movimentacaoMapper, MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoMapper = movimentacaoMapper;
        this.movimentacaoRepository = movimentacaoRepository;
    }

    //LISTAR
    public List<MovimentacaoDTO> movimentacaoListar (){
        List<MovimentacaoModel> listarMov = movimentacaoRepository.findAll();
        return listarMov.stream().map(movimentacaoMapper::map).collect(Collectors.toList());
    }
    //LISTAR POR ID
    public MovimentacaoDTO movimentacaoPorID(Long id){
        Optional<MovimentacaoModel> listarPorID = movimentacaoRepository.findById(id);
        return listarPorID.map(movimentacaoMapper::map).orElse(null);
    }
    //CRIAR
    public MovimentacaoDTO movimentacaoCriar(MovimentacaoDTO movimentacaoDTO){
        MovimentacaoModel movimentacao = movimentacaoMapper.map(movimentacaoDTO);
        movimentacao = movimentacaoRepository.save(movimentacao);
        return movimentacaoMapper.map(movimentacao);
    }
    //ATUALIZAR
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
    //DELETAR
    public void movimentacaoDeletar(Long id){
        movimentacaoRepository.deleteById(id);
    }
    //LISTAR MOVIMENTACOES POR CATEGORIA

    //LISTAR POR RECEITA OU DESPESA

    //LISTAR POR PERIODO DE DATAS

    //CONSULTAR SALDO TOTAL ( DECEITAS - DESPESAS )
}
