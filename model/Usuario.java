package org.generation.lojadegames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Size(min = 2, max = 120, message = "O nome deve conter entre 2 a 120 caracteres")
	private String nome;
	
	@NotNull(message = "O nome de usuário é obrigatório")
	@Size(min = 2, max = 200, message = "O nome de usuário deve conter entre 2 a 200 caracteres")
	private String usuario;
	
	@NotNull(message = "A senha é obrigatória")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
	private String senha;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}