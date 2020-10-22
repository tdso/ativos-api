package com.tdso.ativosapi.repository;

import java.time.LocalDate;
import java.util.List;

import com.tdso.ativosapi.entity.Negociacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NegociacaoRepository extends JpaRepository<Negociacao, Long> {
    
    // List<Negociacao> findByIdAtivo(String idAtivo);
    
    // List<Negociacao> findByIdAtivoAndTipoOperacao(String idAtivo, Integer tipoOperacao);
    
    @Query("SELECT obj FROM Negociacao obj WHERE obj.dataOperacao >= :datade AND obj.dataOperacao <= :dataate")
    List<Negociacao> findNegByDate(@Param("datade") LocalDate datade,
                                   @Param("dataate") LocalDate dataate);

    @Query("SELECT obj FROM Negociacao obj WHERE obj.idAtivo = :nome AND obj.tipoOperacao = :op")
    List<Negociacao> searchAtivo (@Param("nome") String ativo, @Param("op") Integer op);

    @Query("SELECT obj FROM Negociacao obj WHERE obj.idAtivo = :nome AND obj.dataOperacao >= :datade AND obj.dataOperacao <= :dataate AND obj.tipoOperacao = :op")
    List<Negociacao> findNegCustom (@Param("nome") String ativo,
                                    @Param("datade") LocalDate datade,
                                    @Param("dataate") LocalDate dataate,
                                    @Param("op") Integer op);
    
    @Query("SELECT obj FROM Negociacao obj WHERE obj.idAtivo = :nome AND obj.dataOperacao >= :datade AND obj.dataOperacao <= :dataate")
    List<Negociacao> findNegByAtivo( @Param("nome") String ativo,
                                     @Param("datade") LocalDate datade,
                                     @Param("dataate") LocalDate dataate);
    
    @Query("SELECT obj FROM Negociacao obj WHERE obj.dataOperacao >= :datade AND obj.dataOperacao <= :dataate AND obj.tipoOperacao = :op")    
    List<Negociacao> findNegByTipoOp( @Param("op") Integer op,
                                      @Param("datade") LocalDate datade,
                                      @Param("dataate") LocalDate dataate );
}
