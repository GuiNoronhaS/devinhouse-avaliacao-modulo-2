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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.devin.projetoback.devinhouseavaliacaomodulo2.model.Processo;
import br.devin.projetoback.devinhouseavaliacaomodulo2.service.ProcessoService;

@RestController
@RequestMapping("/devinhouse")
public class ProcessoController {
	
	@Autowired
	private ProcessoService service;

	@PostMapping(headers="api-version=2021-04-21", path="/v1/processo"
			, consumes="application/json", produces="application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Processo addProcesso(@Validated @RequestBody Processo processo) {
		return this.service.adicionaProcesso(processo);
	}
	
	@GetMapping(headers="api-version=2021-04-21", path="/v1/processos", produces="application/json")
	public List<Processo> getTodosProcesso() {
		return this.service.pegaTodosProcesso();
	}
	
	@GetMapping(headers="api-version=2021-04-21", path="/v1/processo/{id}", produces="application/json")
	public Processo getProcesso(@PathVariable Long id) {
		return this.service.pegaProcessoPorID(id);
	}
	                                        
	@GetMapping(headers="api-version=2021-04-21", path="/v1/processo", produces="application/json")
	public Processo getProcesso(@RequestParam String chaveProcesso) {
		return this.service.pegaProcessoPorChave(chaveProcesso);
	}
	
	@PutMapping(headers="api-version=2021-04-21", path="/v1/processo/{id}"
			, consumes="application/json", produces="application/json")
	public Processo alterarProcesso(@PathVariable Long id, @Validated @RequestBody Processo novoProcesso){
		return this.service.alterarProcesso(id, novoProcesso);
	}
	
	@DeleteMapping(headers="api-version=2021-04-21", path="/v1/processo/{id}")
	public ResponseEntity<?> deleteProcesso(@PathVariable Long id) {
		return this.service.deletaProcesso(id);
	}
}
