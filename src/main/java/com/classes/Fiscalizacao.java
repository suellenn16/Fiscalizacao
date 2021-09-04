package com.classes;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="fiscalizacao",
indexes = {
		@Index(name = "searchByNameAndUf_Fiscalizacao", columnList = "id_empresa,data") 
		}
)
public class Fiscalizacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_empresa")
	private Empresa empresa;
	
	@ManyToOne
	@JoinColumn(name="id_uf")
	private Uf uf;
	
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;
	
	@ManyToOne
	@JoinColumn(name="id_bairro")
	private Bairro bairro;
	
	@Column(nullable = false )
	private LocalDate data;
	
	@Column(length = 12)
	private String cep;
	
	 @Column(name = "logradouro", length = 100, nullable = false)
	 private String logradouro;

	 public Fiscalizacao(
			    LocalDate data,
			    String logradouro,
			    String cep,
			    Empresa empresa,
			    Bairro bairro,
			    Municipio municipio,
			    Uf uf
			  ) {
			    this.data = data;
			    this.logradouro = logradouro;
			    this.cep = cep;
			    this.empresa = empresa;
			    this.bairro = bairro;
			    this.municipio = municipio;
			    this.uf = uf;
			  }
	 
	 
	 
	public String getLogradouro() {
			return logradouro;
		}

	public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Uf getUf() {
		return uf;
	}

	public void setUf(Uf uf) {
		this.uf = uf;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fiscalizacao other = (Fiscalizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fiscalizacao [id=" + id + ", empresa=" + empresa + ", uf=" + uf + ", municipio=" + municipio
				+ ", bairro=" + bairro + ", data=" + data + ", cep=" + cep + ", logradouro = "+ logradouro +  "]";
	}

}

