package com.tdso.ativosapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<Negociacao> getNegociacaoAll () {
        return repo.findAll();
    }

    public ArrayList<Negociacao> getNegociacaoCustomize () {
        ArrayList<Negociacao> negociacoes = new ArrayList<>();
        return negociacoes;
    }

    public Negociacao getNegociacaoById (Long idNegociacao) throws Exception {
        
        Optional<Negociacao> obj = repo.findById(idNegociacao);
        
        return obj.orElseThrow(() -> new Exception());
        
    }

    public void deleteNegociacao (Long idNegociacao) throws Exception {
        try {
			repo.deleteById(idNegociacao);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception();
		} catch (DataIntegrityViolationException e) {
			throw new Exception(e.getMessage());
		}
    }

    public Negociacao insertNegociacao (Negociacao obj) {
		return repo.save(obj);
	}

}
