package br.com.bloco.controller;

import br.com.bloco.entity.Bloco;
import br.com.bloco.service.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class BlocoController {


    @Autowired
    private BlocoService blocoService;


    @GetMapping("bloco")
    @ResponseStatus(HttpStatus.GONE)
    public List<Bloco> listBlocos(){
        return this.blocoService.listBlocos();
    }


    @GetMapping("bloco/{id}")
    public ResponseEntity<Bloco> getByID(@PathVariable("id") Long id){
        return this.blocoService.getByID(id);

    }
    @PostMapping("bloco/save")
    @ResponseStatus(HttpStatus.OK)
    public Bloco saveBloco(Bloco bloco){
        return this.blocoService.createBloco(bloco);
    }

    @PutMapping("bloco/change/{id}")
    public ResponseEntity<Bloco> changeBloco(@PathVariable("id") Long id,@RequestBody Bloco bloco){
        return this.blocoService.changeFolha(bloco, id);
    }

    @DeleteMapping("bloco/delete/{id}")
    public ResponseEntity<Bloco> deleteBloco(@PathVariable("id") Long id){
       return this.blocoService.deleteBloco(id);
    }

}
