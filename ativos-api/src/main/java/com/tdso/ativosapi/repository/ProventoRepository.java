package com.tdso.ativosapi.repository;

import java.time.LocalDate;
import java.util.List;

import com.tdso.ativosapi.entity.Provento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProventoRepository extends JpaRepository<Provento, Long> {

    @Query("SELECT obj FROM Provento obj WHERE obj.dataPagamento = :datapgto")
    List<Provento> findProvByDate(@Param("datapgto") LocalDate datapgto);

    @Query("SELECT obj FROM Provento obj WHERE obj.dataPagamento = :datapgto AND obj.ativo = :ativo AND obj.tipoProvento = prov")
    List<Provento> findProvByCustom(@Param("datapgto") LocalDate datapgto,
                                    @Param("ativo") String ativo,
                                    @Param("prov") Integer prov );    

    @Query("SELECT obj FROM Provento obj WHERE obj.dataPagamento = :datapgto AND obj.ativo = :ativo")
    List<Provento> findProvByAtivo(@Param("datapgto") LocalDate datapgto,
                                   @Param("ativo") String ativo);    

    @Query("SELECT obj FROM Provento obj WHERE obj.dataPagamento = :datapgto AND obj.tipoProvento = prov")
    List<Provento> findProvByTipo(@Param("datapgto") LocalDate datapgto,
                                  @Param("prov") Integer prov );    
                                                                
    
}
