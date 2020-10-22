package com.tdso.ativosapi.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.tdso.ativosapi.entity.Negociacao;
import com.tdso.ativosapi.repository.NegociacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
@Service
public class NegociacaoService {

    @Autowired
    private NegociacaoRepository repo;

    // ok
    public List<Negociacao> getNegociacaoAll () {
        LocalDate dtfim = LocalDate.now();
        LocalDate dtinicio = dtfim.minusDays(30) ;
        return repo.findNegByDate(dtinicio, dtfim);
    }

    public List<Negociacao> getNegociacaobyDate (String datade, String dataate) {
        LocalDate dtinicio = LocalDate.parse(datade);
        LocalDate dtfim = LocalDate.parse(dataate);
        return repo.findNegByDate(dtinicio, dtfim);
    }

    // ok
    public List<Negociacao> findNegTipo (String ativo, String op){
        LocalDate dtfim = LocalDate.now();
        LocalDate dtinicio = dtfim.minusDays(30) ;
        Integer top = Integer.parseInt(op);
        return repo.findNegCustom(ativo, dtinicio, dtfim, top);
    }

    // ok
    public List<Negociacao> findCustom (String ativo, String dataDe, String dataAte, String tipo){
        LocalDate dtinicio = LocalDate.parse(dataDe);
        LocalDate dtfim = LocalDate.parse(dataAte);
        Integer top = Integer.parseInt(tipo);
        return repo.findNegCustom(ativo, dtinicio, dtfim, top);
    }

    // >>>> testar - ver se vai ter uso
    public Negociacao getNegociacaoById (Long idNegociacao) throws Exception {
        
        Optional<Negociacao> obj = repo.findById(idNegociacao);
        
        return obj.orElseThrow(() -> new Exception());
        
    }

    // ok
    public void deleteNegociacao (Long idNegociacao) throws Exception {
        try {
			repo.deleteById(idNegociacao);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception();
		} catch (DataIntegrityViolationException e) {
			throw new Exception(e.getMessage());
		}
    }

    // ok
    public Negociacao insertNegociacao (Negociacao obj) {
		return repo.save(obj);
	}
    
    // ok
    public List<Negociacao> getNegociacaoByAtivo(String ativo){
        LocalDate dtfim = LocalDate.now();
        LocalDate dtinicio = dtfim.minusDays(30) ;
        return repo.findNegByAtivo(ativo, dtinicio, dtfim);
    }
    public List<Negociacao> getNegociacaoByAtivoAndData(String ativo, String datade, String dataate) {
        LocalDate dtinicio = LocalDate.parse(datade);
        LocalDate dtfim = LocalDate.parse(dataate);
        return repo.findNegByAtivo(ativo, dtinicio, dtfim);
    }
    
    // ok
    public List<Negociacao> getNegociacaoByTipoOp(String tipo) {
        LocalDate dtfim = LocalDate.now();
        LocalDate dtinicio = dtfim.minusDays(30) ;
        Integer tipoOp = Integer.parseInt(tipo);
        return repo.findNegByTipoOp(tipoOp, dtinicio, dtfim);
    }

    public List<Negociacao> getNegociacaoByTipoOpAndData(String tipo, String datade, String dataate){
        LocalDate dtinicio = LocalDate.parse(datade);
        LocalDate dtfim = LocalDate.parse(dataate);
        Integer tipoOp = Integer.parseInt(tipo);
        return repo.findNegByTipoOp(tipoOp, dtinicio, dtfim);
    }
}
