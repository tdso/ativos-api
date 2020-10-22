package com.tdso.ativosapi.resource;

import java.time.LocalDate;
import java.util.ArrayList;

import com.tdso.ativosapi.entity.Negociacao;
import com.tdso.ativosapi.service.NegociacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/negociacoes")
public class NegociacaoResource {

    @Autowired
    private NegociacaoService service;
    
    // ok - sem parametros - data assumida = ultimos 30 dias
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getNegociacoes() {
        return ResponseEntity.ok().body(service.getNegociacaoAll());
    }
    
    // ok - ativo + tipo de operacao = data assumida ultimos 30 dias 
    @RequestMapping(value = "/{ativo}/{opt}", method = RequestMethod.GET)
    public ResponseEntity getNegTipoOp(@PathVariable("ativo") String at, @PathVariable("opt") String op) {
        return ResponseEntity.ok().body(service.findNegTipo(at, op));
    }
    
    // ok - todos os parametros
    @RequestMapping(value = "/{ativo}/{datade}/{dataate}/{top}", method = RequestMethod.GET)
    public ResponseEntity getNegociacoesCustom(
        @PathVariable("ativo") String ativo,
        @PathVariable("datade") String datade,
        @PathVariable("dataate") String dataate,
        @PathVariable("top") String op) {

        return ResponseEntity.ok().body(service.findCustom(ativo, datade, dataate, op));
    }

    // ok - dataInicio e dataFim
    @RequestMapping(value = "negdata/{datade}/{dataate}", method = RequestMethod.GET)
    public ResponseEntity getNegociacoesByData(
        @PathVariable("datade") String datade,
        @PathVariable("dataate") String dataate) {
        return ResponseEntity.ok().body(service.getNegociacaobyDate(datade, dataate));
    }

    // ok - apenas o ativo - data assumida = ultimos 30 dias
    @RequestMapping(value = "negativo/{ativo}", method = RequestMethod.GET)
    public ResponseEntity getNegByAtivo(
        @PathVariable("ativo") String ativo) {
        return ResponseEntity.ok().body(service.getNegociacaoByAtivo(ativo));
    }

    // ok - ativos e datas
    @RequestMapping(value = "negativo/{ativo}/{datade}/{dataate}", method = RequestMethod.GET)
    public ResponseEntity getNegByAtivo(
        @PathVariable("ativo") String ativo,
        @PathVariable("datade") String datade,
        @PathVariable("dataate") String dataate) {
        return ResponseEntity.ok().body(service.getNegociacaoByAtivoAndData(ativo, datade, dataate));
    }
    
    // ok - apenas o tipo - data assumida = ultimos 30 dias
    @RequestMapping(value = "negtipo/{tipo}", method = RequestMethod.GET)
    public ResponseEntity getNegByTipoOp(
        @PathVariable("tipo") String tipo) {
        return ResponseEntity.ok().body(service.getNegociacaoByTipoOp(tipo));
    }

    // ok - tipo e datas
    @RequestMapping(value = "negtipo/{tipo}/{datade}/{dataate}", method = RequestMethod.GET)
    public ResponseEntity getNegByTipoOp(
        @PathVariable("tipo") String tipo,
        @PathVariable("datade") String datade,
        @PathVariable("dataate") String dataate) {
        return ResponseEntity.ok().body(service.getNegociacaoByTipoOpAndData(tipo, datade, dataate));
    }

    // // testando
    // @RequestMapping(value = "/{ativo}/{op}", method = RequestMethod.GET)
    // public ResponseEntity getAtivosTeste(@PathVariable("ativo") String ativo, @PathVariable("op") Integer op) {
    //     return ResponseEntity.ok().body(service.getNegTipoOp(ativo, op));
    // }
    
    // @RequestMapping(value = "/{idNegociacao}", method = RequestMethod.GET)
    // public ResponseEntity getNegociacaoById(@PathVariable("idNegociacao") Long id) {
    //     Negociacao neg;
    //     try {
    //         neg = service.getNegociacaoById(id);
    //         return ResponseEntity.ok().body(neg);
    //     } catch (Exception e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
    //     return ResponseEntity.ok().body("Negociacao não encontrada - caixa 2");
    // }
    // @RequestMapping(method = RequestMethod.GET)
    // public ResponseEntity getAtivos() {
    //     return ResponseEntity.ok().body(service.getNegociacaoAll());
    // }
    
    // // @RequestMapping(value = "/{ativo}/{tipoOperacao}", method = RequestMethod.GET)
    // // public ResponseEntity getAtivos(@PathVariable("ativo") String ativo, @PathVariable("tipoOperacao") Integer tipoOp) {
    // //     ArrayList<Negociacao> negociacoes = new ArrayList<>();
    // //     negociacoes.add(new Negociacao(ativo, LocalDate.now(), 100, 99.01, tipoOp));
    // //     return ResponseEntity.ok().body(negociacoes);
    // // }

    @RequestMapping(value = "/{idNegociacao}", method = RequestMethod.DELETE)
    public ResponseEntity deleteNegociacao(@PathVariable("idNegociacao") String idNegociacao) {
        try {
            System.out.println("id = " + idNegociacao);
            Long idNeg = Long.parseLong(idNegociacao);
            service.deleteNegociacao(idNeg);
            return ResponseEntity.ok().body("Exclusao efetuada !!");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok().body("Erro ao excluir negociacao ... Ligue BOVESPA");
    }

    @PostMapping
    public ResponseEntity<Negociacao> insertNegociacao(@RequestBody Negociacao neg) {
        neg = service.insertNegociacao(neg);
        return ResponseEntity.ok().body(neg);  
    }

    
}
