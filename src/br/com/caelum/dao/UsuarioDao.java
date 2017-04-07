package br.com.caelum.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.caelum.modelo.Usuario;

@Repository
public class UsuarioDao {
	
	@PersistenceContext
	private EntityManager manager;

	public Usuario buscaUsuario(Usuario usuario){
		Query query = manager.createQuery("select u from Usuario u where u.login = :login and u.senha = :senha");
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		
		try{
			Usuario usuarioEncontrado = (Usuario)query.getSingleResult();
			
			return usuarioEncontrado;
		}catch(NoResultException err){
			return null;
		}
	}
	
}
