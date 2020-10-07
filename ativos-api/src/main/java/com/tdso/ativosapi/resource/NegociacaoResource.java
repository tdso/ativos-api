package com.tdso.ativosapi.resource;

import java.time.LocalDate;
import java.util.ArrayList;

import com.tdso.ativosapi.entity.Negociacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ativos")
public class NegociacaoResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAtivos (){
        ArrayList<Negociacao> negociacoes = new ArrayList<>();
        negociacoes.add(new Negociacao("TRXF11", LocalDate.now(), 500, 101.01, 1));
        negociacoes.add(new Negociacao("HGRU11", LocalDate.now(), 900, 105.29, 1));
        negociacoes.add(new Negociacao("TAEE11", LocalDate.now(), 200, 27.00, 2));
        return ResponseEntity.ok().body(negociacoes);
    }
    
}
