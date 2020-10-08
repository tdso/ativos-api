package com.tdso.ativosapi.repository;

import com.tdso.ativosapi.entity.Negociacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NegociacaoRepository extends JpaRepository<Negociacao, Long> {
    
}
