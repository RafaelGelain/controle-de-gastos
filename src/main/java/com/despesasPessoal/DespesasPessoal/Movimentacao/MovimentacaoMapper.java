package com.despesasPessoal.DespesasPessoal.Movimentacao;

import org.springframework.stereotype.Component;

@Component
public class MovimentacaoMapper {
    public MovimentacaoDTO map(MovimentacaoModel movimentacaoModel){
        MovimentacaoDTO movimentacaoDTO = new MovimentacaoDTO();
        movimentacaoDTO.setId(movimentacaoModel.getId());
        movimentacaoDTO.setData(movimentacaoModel.getData());
        movimentacaoDTO.setCategoria(movimentacaoModel.getCategoria());
        movimentacaoDTO.setTipo(movimentacaoModel.getTipo());
        movimentacaoDTO.setDescricao(movimentacaoModel.getDescricao());
        movimentacaoDTO.setObservacao(movimentacaoModel.getObservacao());
        movimentacaoDTO.setValor(movimentacaoModel.getValor());
        return movimentacaoDTO;
    }

    public MovimentacaoModel map(MovimentacaoDTO movimentacaoDTO){
        MovimentacaoModel movimentacaoModel = new MovimentacaoModel();
        movimentacaoModel.setId(movimentacaoDTO.getId());
        movimentacaoModel.setData(movimentacaoDTO.getData());
        movimentacaoModel.setCategoria(movimentacaoDTO.getCategoria());
        movimentacaoModel.setTipo(movimentacaoDTO.getTipo());
        movimentacaoModel.setDescricao(movimentacaoDTO.getDescricao());
        movimentacaoModel.setObservacao(movimentacaoDTO.getObservacao());
        movimentacaoModel.setValor(movimentacaoDTO.getValor());
        return movimentacaoModel;
    }
}
