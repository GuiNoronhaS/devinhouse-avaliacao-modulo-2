package br.devin.projetoback.devinhouseavaliacaomodulo2.repository;

import br.devin.projetoback.devinhouseavaliacaomodulo2.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRep extends JpaRepository<Processo, Long>{

}
