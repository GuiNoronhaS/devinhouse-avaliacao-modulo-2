package br.devin.projetoback.devinhouseavaliacaomodulo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.devin.projetoback.devinhouseavaliacaomodulo2.exception.ProcessoNotFoundException;
import br.devin.projetoback.devinhouseavaliacaomodulo2.model.Processo;
import br.devin.projetoback.devinhouseavaliacaomodulo2.repository.ProcessoRep;

@Service
public class ProcessoService {
	
	@Autowired
	private ProcessoRep processorep;
	
	public Processo adicionaProcesso(Processo processo) {
		return this.processorep.save(processo);
	}
	
	public List<Processo> pegaTodosProcesso() {
		return this.processorep.findAll();
	}
	
	public Processo pegaProcessoPorID(Long id) {
		return this.processorep.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe um ID valido para o Processo.")
				);
	}
	                                        
	public Processo pegaProcessoPorChave(String chaveProcesso) {
		try {
			List<Processo> lista = this.pegaTodosProcesso();
			for(Processo processo : lista) {
				if(chaveProcesso.equals(processo.getChaveProcesso())) {
					return processo;
				}
			}		
			throw new ProcessoNotFoundException("Erro - Proceso Não Encontrado");
		} catch(ProcessoNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe uma Chave de Processo valida.");
		}
	}
	
	public Processo alterarProcesso(Long id, Processo novoProcesso){
		novoProcesso.setId(id);
		return this.processorep.save(novoProcesso);
	}
	
	public ResponseEntity<?> deletaProcesso(Long id) {
		this.processorep.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
