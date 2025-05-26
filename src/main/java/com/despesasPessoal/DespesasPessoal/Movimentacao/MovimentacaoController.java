package com.despesasPessoal.DespesasPessoal.Movimentacao;

import com.despesasPessoal.DespesasPessoal.Categoria.CategoriaDTO;
import com.despesasPessoal.DespesasPessoal.Categoria.TipoCategoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping()
    public ResponseEntity<List<MovimentacaoDTO>> movimentacaoListar(){
        List<MovimentacaoDTO> listarMovimentacao = movimentacaoService.movimentacaoListar();
        return ResponseEntity.ok(listarMovimentacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> movimentacaoPorID(@PathVariable Long id){
        MovimentacaoDTO movimentacaoDTO = movimentacaoService.movimentacaoPorID(id);
        if (movimentacaoDTO != null){
            return ResponseEntity.ok(movimentacaoDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movimentacao com o ID "+id+" nao encontrada, tente outro");
        }
    }

    @PostMapping()
    public ResponseEntity<String> movimentacaoCriar(@RequestBody MovimentacaoDTO movimentacaoDTO){
        MovimentacaoDTO movimentacao = movimentacaoService.movimentacaoCriar(movimentacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Movimentacao criada com sucesso.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> movimentacaoAlterar(@PathVariable Long id, @RequestBody MovimentacaoDTO movimentacaoDTO){
        MovimentacaoDTO movimentacao = movimentacaoService.movimentacaoAtualizar(id ,movimentacaoDTO);
        if (movimentacao != null){
            return ResponseEntity.ok(movimentacao);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("a movimentacao com ID "+id+" nao foi encontrada para realizar a alteracao");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> movimentacaoDeletar(@PathVariable Long id){
        if (movimentacaoService.movimentacaoPorID(id)!=null) {
            movimentacaoService.movimentacaoDeletar(id);
            return ResponseEntity.ok("Deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("a movimentacao com o ID "+id+" nao foi encontrada, verifique se esta correto");
        }
    }
    //todo: VERIFICAR AMANHA COMO POSSO USAR O NOME DESSA FUNCAO ABAIXO || ELA VAI VERIFICAR O FLUXO POR TIPO ( DESPESA OU RECEITA )
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<MovimentacaoDTO>> movimentacaoPorFluxo(@PathVariable TipoCategoria tipo){
        List<MovimentacaoDTO> movimentacaoFiltrada = movimentacaoService.movimentacaoFiltrarPorTipo(tipo);
        return ResponseEntity.ok(movimentacaoFiltrada);
    }

    @GetMapping("/categoria/{id}")
    public ResponseEntity<List<MovimentacaoDTO>> movimentacaoPorCategoria(@PathVariable Long id){
        List<MovimentacaoDTO> movimentacaoCategoria = movimentacaoService.movimentacaoFiltrarPorCategoria(id);
        return ResponseEntity.ok(movimentacaoCategoria);
    }

    @GetMapping("/data/{dataInicio}/{dataFim}")
    public ResponseEntity<List<?>> movimentaoPorData(@PathVariable LocalDate dataInicio, @PathVariable LocalDate dataFim){
        List<MovimentacaoDTO> movimentacao = movimentacaoService.movimentacaoFiltrarPorData(dataInicio, dataFim);
        return ResponseEntity.ok(movimentacao);
    }




}
