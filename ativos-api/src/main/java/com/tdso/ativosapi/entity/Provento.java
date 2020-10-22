package com.tdso.ativosapi.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor  // gera construtor vazio
public class Provento  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Long id;
    private String ativo;
    private LocalDate dataBase;
    private LocalDate dataPagamento;
    private Integer tipoProvento;
    private Double valor;
    
    public Provento (String ativo, LocalDate dataBase, LocalDate dataPagto, Integer tipoProv, Double vlr ){
        this.ativo = ativo;
        this.dataBase = dataBase;
        this.dataPagamento = dataPagto;
        this.tipoProvento = tipoProv;
        this.valor = vlr;
    }
}
