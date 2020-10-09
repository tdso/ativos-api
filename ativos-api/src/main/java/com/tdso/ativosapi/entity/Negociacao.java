package com.tdso.ativosapi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Negociacao implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    @Getter private Long idNegociacao;
    @Getter @Setter private String idAtivo;
    @Getter @Setter private LocalDate dataOperacao;
    @Getter @Setter private Integer quantidade;
    @Getter @Setter private Double preco;
    @Getter @Setter private Integer tipoOperacao;

    public Negociacao(){}
    public Negociacao(String ativo, LocalDate data, Integer qtde, Double preco, Integer tipoOperacao){
        this.idAtivo = ativo;
        this.dataOperacao = data;
        this.quantidade = qtde;
        this.preco = preco;
        this.tipoOperacao = tipoOperacao;

    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNegociacao == null) ? 0 : idNegociacao.hashCode());
		return result;
	}

    @Override
    public boolean equals(Object obj){
        if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Negociacao other = (Negociacao) obj;
		if (idNegociacao == null) {
			if (other.idNegociacao != null)
				return false;
		} else if (!idNegociacao.equals(other.idNegociacao))
			return false;
		return true;        
    }
}

