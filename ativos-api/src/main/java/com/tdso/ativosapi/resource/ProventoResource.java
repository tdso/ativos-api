package com.tdso.ativosapi.resource;

import com.tdso.ativosapi.entity.Provento;
import com.tdso.ativosapi.service.ProventoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/provento")
public class ProventoResource {
    
    @Autowired
    private ProventoService service;

    // - sem parametros - data assumida = mes anterior 
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getProventos() {
        return ResponseEntity.ok().body(service.getProventoByDataPagto(""));
    }

    // - mes pagto
    @RequestMapping(value = "/{datapgto}", method = RequestMethod.GET)
    public ResponseEntity getProventosBydata(
        @PathVariable("datapgto") String datapgto){
        return ResponseEntity.ok().body(service.getProventoByDataPagto(datapgto));
    }

    // - todos os parametros
    @RequestMapping(value = "/{datapgto}/{ativo}/{provento}", method = RequestMethod.GET)
    public ResponseEntity getProventosByCustom(
        @PathVariable("datapgto") String datapgto,
        @PathVariable("ativo") String ativo,
        @PathVariable("provento") String provento) {

        return ResponseEntity.ok().body(service.getProventoCustom(datapgto, ativo, provento));
    }

    // - dtpagtp + ativo
    @RequestMapping(value = "/ativo/{datapgto}/{ativo}", method = RequestMethod.GET)
    public ResponseEntity getProventosByDataAndAtivo(
        @PathVariable("datapgto") String datapgto,
        @PathVariable("ativo") String ativo) {

        return ResponseEntity.ok().body(service.getProventoByDataAndAtivo(datapgto, ativo));
    }

    // - dtpagtp + provento
    @RequestMapping(value = "/tipo/{datapgto}/{provento}", method = RequestMethod.GET)
    public ResponseEntity getProventosByDataAndProvento(
        @PathVariable("datapgto") String datapgto,
        @PathVariable("provento") String provento) {

        return ResponseEntity.ok().body(service.getProventoByDataAndProvento(datapgto, provento));
    }

    // - id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProvento(@PathVariable("id") String id) throws Exception {
            Long idL = Long.parseLong(id);
            service.deleteProvento(idL);
            return ResponseEntity.ok().body("Exclusao ok");
    }

    @PostMapping
    public ResponseEntity<Provento> insertProvento(@RequestBody Provento prov) {
        prov = service.insertProvento(prov);
        return ResponseEntity.ok().body(prov);  
    }
 
}
