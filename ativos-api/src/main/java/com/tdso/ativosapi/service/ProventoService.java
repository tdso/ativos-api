package com.tdso.ativosapi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tdso.ativosapi.entity.Provento;
import com.tdso.ativosapi.repository.ProventoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProventoService {

    @Autowired
    private ProventoRepository repo;

    public List<Provento> getProventoByDataPagto(String dt_pgto) {
        LocalDate datapgto;
        if (dt_pgto.isEmpty()){
            datapgto = LocalDate.now();
            Integer mes = datapgto.getMonthValue();
            Integer ano = datapgto.getYear();
            if (mes == 1) {
                ano = ano - 1;
                mes = 12;
            } else {
                mes = mes - 1;
            }
            String mesTxt = String.valueOf(mes);
            if (mesTxt.length() == 1) mesTxt = '0' + mesTxt; 
            String dataTxt = String.valueOf(ano) + "-" + mesTxt + "-" + "01";
            datapgto = LocalDate.parse(dataTxt);
        } else {
            datapgto = LocalDate.parse(dt_pgto);
        }
        return repo.findProvByDate(datapgto);
    }

    public List<Provento> getProventoCustom (String datapgto, String ativo, String provento){
        LocalDate dtpgto = LocalDate.parse(datapgto);
        Integer prov = Integer.parseInt(provento);
        return repo.findProvByCustom(dtpgto, ativo, prov);
    }

    public List<Provento> getProventoByDataAndAtivo(String datapgto, String ativo) {
        LocalDate dtpgto = LocalDate.parse(datapgto);
        return repo.findProvByAtivo(dtpgto, ativo);
    }

    public List<Provento> getProventoByDataAndProvento(String datapgto, String provento) {
        LocalDate dtpgto = LocalDate.parse(datapgto);
        Integer prov = Integer.parseInt(provento);
        return repo.findProvByTipo(dtpgto, prov);
    }

    public void deleteProvento (Long idNegociacao) throws Exception {
        try {
			repo.deleteById(idNegociacao);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception();
		} catch (DataIntegrityViolationException e) {
			throw new Exception(e.getMessage());
		}
    }

    public Provento insertProvento (Provento obj) {
		return repo.save(obj);
	}
    
}
