package br.senai.sp.todolist.dao;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;


import br.senai.sp.todolist.modelo.Usuario;

public class UsuarioDao {
	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(Usuario usuario){
		manager.persist(usuario);
	}
	
	public Usuario logar(Usuario usuario){
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.login = :login and"+"u.senha = :senha",Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		try{
			return query.getSingleResult();
		} catch (Exception e){
			return null;
		}
	}

}
