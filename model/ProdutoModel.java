package org.generation.lojadegames.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O nome do produto é obrigatório.")
	@Size(min = 5, max = 30, message = "O nome deve conter entre 5 e 30 caracteres.")
	private String nomeProd;
	
	@NotBlank(message = "A descrição do produto é obrigatória.")
	@Size(min = 10, max = 500, message = "A descrição deve conter entre 10 e 500 caracteres.")
	private String descricaoProd;
	
	@NotNull(message = "O preço do produto é obrigatório.")
	private double precoProd;
	
	@NotNull(message = "O código do produto é obrigatório.")
	private long codigoBarrasProd;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInsercaoProd = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private CategoriaModel categoria;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getDescricaoProd() {
		return descricaoProd;
	}

	public void setDescricaoProd(String descricaoProd) {
		this.descricaoProd = descricaoProd;
	}

	public double getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(double precoProd) {
		this.precoProd = precoProd;
	}

	public long getCodigoBarrasProd() {
		return codigoBarrasProd;
	}

	public void setCodigoBarrasProd(long codigoBarrasProd) {
		this.codigoBarrasProd = codigoBarrasProd;
	}

	public Date getDataInsercaoProd() {
		return dataInsercaoProd;
	}

	public void setDataInsercaoProd(Date dataInsercaoProd) {
		this.dataInsercaoProd = dataInsercaoProd;
	}

	public CategoriaModel getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}
}