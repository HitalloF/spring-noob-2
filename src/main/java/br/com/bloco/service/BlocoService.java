package br.com.bloco.service;

import br.com.bloco.entity.Bloco;
import br.com.bloco.repository.BlocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlocoService {

    @Autowired
    BlocoRepository blocoRepository;

    public List<Bloco> listBlocos(){
        Iterable<Bloco> blocoIterable = this.blocoRepository.findAll();
        return Streamable.of(blocoIterable).toList();
    }

    public Bloco createBloco(Bloco bloco){
        return this.blocoRepository.save(bloco);
    }

    public ResponseEntity<Bloco>  getByID(Long id){
        Optional<Bloco> folha = this.blocoRepository.findById(id);
        if(folha.isPresent())
            return new ResponseEntity<Bloco>(folha.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Bloco> deleteBloco(Long id){
        Optional<Bloco> pessoa = this.blocoRepository.findById(id);
        if(pessoa.isPresent()){
            this.blocoRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Bloco> changeFolha(Bloco newBloco, Long id){
         Optional<Bloco> oldBloco = this.blocoRepository.findById(id);
         if(oldBloco.isPresent()){
             Bloco bloco = oldBloco.get();
             bloco.setName(newBloco.getName());
             this.blocoRepository.save(bloco);
             return new ResponseEntity<Bloco>(bloco, HttpStatus.OK);
         }
         else
             return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
