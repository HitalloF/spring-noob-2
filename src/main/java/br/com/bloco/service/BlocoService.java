package br.com.bloco.service;

import br.com.bloco.entity.Bloco;
import br.com.bloco.repository.BlocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
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

    public Optional<Bloco> getForId(Long id){
        return this.blocoRepository.findById(id);
    }

    public void deleteFolha(Long id){
        this.blocoRepository.deleteById(id);
    }

    public ResponseEntity<Bloco> changeFolha(Bloco bloco, Long id){
        return this.blocoRepository.findById(id).map(change ->{
            change.setName(bloco.getName());
            Bloco updated = this.blocoRepository.save(change);
            return ResponseEntity.ok().body(updated);
            }).orElse(ResponseEntity.notFound().build());
    }

}
