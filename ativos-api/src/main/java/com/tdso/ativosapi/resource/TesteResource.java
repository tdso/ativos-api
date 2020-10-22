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
@RequestMapping(value = "/teste")
public class TesteResource {

    @Autowired
    private NegociacaoService service;
    
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

    // ok - sem parametros - data assumida = ultimos 30 dias
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getNegociacoes() {
        return ResponseEntity.ok().body(service.getNegociacaoAll());
    }

    // ok - apenas o ativo - data assumida = ultimos 30 dias
    @RequestMapping(value = "negativo/{ativo}", method = RequestMethod.GET)
    public ResponseEntity getNegByAtivo(
        @PathVariable("ativo") String ativo) {
        return ResponseEntity.ok().body(service.getNegociacaoByAtivo(ativo));
    }
    
    // ok - apenas o tipo - data assumida = ultimos 30 dias
    @RequestMapping(value = "negtipo/{tipo}", method = RequestMethod.GET)
    public ResponseEntity getNegByTipoOp(
        @PathVariable("tipo") String tipo) {
        return ResponseEntity.ok().body(service.getNegociacaoByTipoOp(tipo));
    }
    
}
