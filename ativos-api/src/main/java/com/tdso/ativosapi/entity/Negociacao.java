package com.tdso.ativosapi.entity;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

public class Negociacao {
    @Getter @Setter private String idAtivo;
    @Getter @Setter private LocalDate dataOperacao;
    @Getter @Setter private Integer quantidade;
    @Getter @Setter private Double preco;
    @Getter @Setter private Integer tipoOperacao;

    public Negociacao(String ativo, LocalDate data, Integer qtde, Double preco, Integer tipoOperacao){
        this.idAtivo = ativo;
        this.dataOperacao = data;
        this.quantidade = qtde;
        this.preco = preco;
        this.tipoOperacao = tipoOperacao;

    }


}

