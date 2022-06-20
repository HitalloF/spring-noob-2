package br.com.bloco.controller;

import br.com.bloco.entity.Bloco;
import br.com.bloco.service.BlocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    BlocoService blocoService;

    /* Find All */
    @GetMapping("bloco")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Bloco> listBlocos(){
        return this.blocoService.listBlocos();
    }
    /* Save */
    @PostMapping("bloco/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Bloco createBlock(@RequestBody Bloco bloco){
        return this.blocoService.createBloco(bloco);
    }
    /* find by ID */
    @GetMapping("bloco/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<Bloco> getBlocoId(@PathVariable("id") Long id){
        return this.blocoService.getForId(id);
    }
    /* Deleta */
    @DeleteMapping("bloco/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteFolha(@PathVariable("id") Long id){
        this.blocoService.deleteFolha(id);
    }
    /*alterar*/
    @PutMapping("bloco/change/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public ResponseEntity<Bloco> changeFolha(@PathVariable("id")Long id, @RequestBody Bloco bloco){
        return this.blocoService.changeFolha(bloco, id);
    }


}
