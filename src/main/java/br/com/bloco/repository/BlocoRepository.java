package br.com.bloco.repository;

import br.com.bloco.entity.Bloco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlocoRepository extends JpaRepository<Bloco, Long> {
}
