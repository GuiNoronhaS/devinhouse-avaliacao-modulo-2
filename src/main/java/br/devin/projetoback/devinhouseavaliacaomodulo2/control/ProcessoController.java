package br.devin.projetoback.devinhouseavaliacaomodulo2.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.devin.projetoback.devinhouseavaliacaomodulo2.exception.ProcessoNotFoundException;
import br.devin.projetoback.devinhouseavaliacaomodulo2.model.Processo;
import br.devin.projetoback.devinhouseavaliacaomodulo2.repository.ProcessoRep;

@RestController
@RequestMapping("/devinhouse")
public class ProcessoController {
	
	@Autowired
	private ProcessoRep processorep;

	@PostMapping(headers="api-version=2021-04-21", path="/v1/processo"
			, consumes="application/json", produces="application/json")
	public Processo addProcesso(@Validated @RequestBody Processo processo) {
		return this.processorep.save(processo);
	}
	
	@GetMapping(headers="api-version=2021-04-21", path="/v1/processos", produces="application/json")
	public List<Processo> getTodosProcesso() {
		return this.processorep.findAll();
	}
	
	@GetMapping(headers="api-version=2021-04-21", path="/v1/processo/{id}", produces="application/json")
	public Processo getProcesso(@PathVariable Long id) {
		return this.processorep.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Informe um ID valido para o Processo.")
				);
	}
	                                        
	@GetMapping(headers="api-version=2021-04-21", path="/v1/processo", produces="application/json")
	public Processo getProcesso(@RequestParam String chaveProcesso) {
		try {
			List<Processo> lista = this.processorep.findAll();
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
	
	@PutMapping(headers="api-version=2021-04-21", path="/v1/processo/{id}"
			, consumes="application/json", produces="application/json") 
	public Processo alterarProcesso(@PathVariable Long id, @Validated @RequestBody Processo novoProcesso){
		novoProcesso.setId(id);
		return this.processorep.save(novoProcesso);
	}
	
	@DeleteMapping(headers="api-version=2021-04-21", path="/v1/processo/{id}")
	public ResponseEntity<?> deleteProcesso(@PathVariable Long id) {
		this.processorep.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
