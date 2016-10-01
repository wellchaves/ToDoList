package br.senai.sp.todolist.modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class Usuario {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		Md5PasswordEncoder encorder = new Md5PasswordEncoder();
		senha = encorder.encodePassword(senha, null);
		this.senha = senha;
	}
	
	
}