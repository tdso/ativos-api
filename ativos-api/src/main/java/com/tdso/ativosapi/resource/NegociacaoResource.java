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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAtivos() {
        return ResponseEntity.ok().body(service.getNegociacaoAll());
    }

    @RequestMapping(value = "/{idNegociacao}", method = RequestMethod.GET)
    public ResponseEntity getAtivos(@PathVariable("idNegociacao") Long id) {
        Negociacao neg;
        try {
            neg = service.getNegociacaoById(id);
            return ResponseEntity.ok().body(neg);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.ok().body("Negociacao não encontrada - caixa 2");
    }

    @RequestMapping(value = "/{ativo}/{tipoOperacao}", method = RequestMethod.GET)
    public ResponseEntity getAtivos(@PathVariable("ativo") String ativo, @PathVariable("tipoOperacao") Integer tipoOp) {
        ArrayList<Negociacao> negociacoes = new ArrayList<>();
        negociacoes.add(new Negociacao(ativo, LocalDate.now(), 100, 99.01, tipoOp));
        return ResponseEntity.ok().body(negociacoes);
    }

    @RequestMapping(value = "/{idNegociacao}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAtivos(@PathVariable("idNegociacao") String idNegociacao) {
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
