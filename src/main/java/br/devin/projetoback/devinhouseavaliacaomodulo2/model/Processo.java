package br.devin.projetoback.devinhouseavaliacaomodulo2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="table_processo")
public class Processo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String chaveProcesso;
	private String sgOrgaoProcesso;
	private Integer nuProcesso;
	private String nuAnoProcesso;
	private String descricao;
	private	Integer cdAssunto;
	private String descricaoAssunto;
	private Integer cdInteressado;
	private String nmInteressado;
	
	public Processo() {
	}
	
	public Processo(String chaveProcesso, String sgOrgaoProcesso, Integer nuProcesso, String nuAnoProcesso,
			 String descricao, Integer cdAssunto, String descricaoAssunto, Integer cdInteressado,
			 String nmInteressado ) {
		 this.chaveProcesso = chaveProcesso;
		 this.sgOrgaoProcesso = sgOrgaoProcesso;
		 this.nuProcesso = nuProcesso;
		 this.nuAnoProcesso = nuAnoProcesso;
		 this.descricao = descricao;
		 this.cdAssunto = cdAssunto;
		 this.descricaoAssunto = descricaoAssunto;
		 this.cdInteressado = cdInteressado;
		 this.nmInteressado = nmInteressado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChaveProcesso() {
		return chaveProcesso;
	}

	public void setChaveProcesso(String chaveProcesso) {
		this.chaveProcesso = chaveProcesso;
	}

	public String getSgOrgaoProcesso() {
		return sgOrgaoProcesso;
	}

	public void setSgOrgaoProcesso(String sgOrgaoProcesso) {
		this.sgOrgaoProcesso = sgOrgaoProcesso;
	}

	public Integer getNuProcesso() {
		return nuProcesso;
	}

	public void setNuProcesso(Integer nuProcesso) {
		this.nuProcesso = nuProcesso;
	}

	public String getNuAnoProcesso() {
		return nuAnoProcesso;
	}

	public void setNuAnoProcesso(String nuAnoProcesso) {
		this.nuAnoProcesso = nuAnoProcesso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCdAssunto() {
		return cdAssunto;
	}

	public void setCdAssunto(Integer cdAssunto) {
		this.cdAssunto = cdAssunto;
	}

	public String getDescricaoAssunto() {
		return descricaoAssunto;
	}

	public void setDescricaoAssunto(String descricaoAssunto) {
		this.descricaoAssunto = descricaoAssunto;
	}

	public Integer getCdInteressado() {
		return cdInteressado;
	}

	public void setCdInteressado(Integer cdInteressado) {
		this.cdInteressado = cdInteressado;
	}

	public String getNmInteressado() {
		return nmInteressado;
	}

	public void setNmInteressado(String nmInteressado) {
		this.nmInteressado = nmInteressado;
	}

}
