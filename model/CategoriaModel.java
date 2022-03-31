package org.generation.lojadegames.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class CategoriaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCateg;
	
	@NotBlank(message = "O nome é obrigatório.")
	@Size(min = 5, max = 60, message = "O nome deve conter entre 5 e 60 caracteres.")
	private String nomeCateg;
	
	@NotBlank(message = "O tipo é obrigatório.")
	@Size(min = 5, max = 100, message = "O nome deve conter entre 5 e 100 caracteres.")
	private String tipoCateg;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacaoCateg = new java.sql.Date(System.currentTimeMillis());
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> produto;

	public long getIdCateg() {
		return idCateg;
	}

	public void setIdCateg(long idCateg) {
		this.idCateg = idCateg;
	}

	public String getNomeCateg() {
		return nomeCateg;
	}

	public void setNomeCateg(String nomeCateg) {
		this.nomeCateg = nomeCateg;
	}

	public String getTipoCateg() {
		return tipoCateg;
	}

	public void setTipoCateg(String tipoCateg) {
		this.tipoCateg = tipoCateg;
	}

	public Date getDataCriacaoCateg() {
		return dataCriacaoCateg;
	}

	public void setDataCriacaoCateg(Date dataCriacaoCateg) {
		this.dataCriacaoCateg = dataCriacaoCateg;
	}

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}
}