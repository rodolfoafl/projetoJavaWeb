package projetoJavaWeb.DAO;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoJavaWeb.entity.Usuario;

public class UsuarioDAO {
	EntityManager em = Conexao.getInstance().createEntityManager();
	
	public void inserir(Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
	}

	public Usuario buscar(String login, String senha) {
		Query q = em.createQuery("select u from Usuario u "
				+ "where u.login = :login and u.senha = :senha ");
		q.setParameter("login", login);
		q.setParameter("senha", senha);
		try {
			return (Usuario) q.getSingleResult();
		} catch (Exception ex) {
			return null;
		}	
	}	
	
	@SuppressWarnings("unchecked")
	public ArrayList<Usuario> listar() {
		Query q = em.createQuery("from Usuario");
		
		return new ArrayList<Usuario>(q.getResultList());
	}
	
	public void alterar(Usuario usuario) {	
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
	}
	
	public void remover(Integer id) {	
		em.getTransaction().begin();
		Usuario Usuario = em.find(Usuario.class, id);		
		em.remove(Usuario);
		em.getTransaction().commit();
	}
//
//	public Usuario buscarUsuario(String login, String senha) {
//		Query q = em.createQuery("select u from Usuario u "
//				+ "where u.login = :login and u.senha = :senha "
//				+ "and u.tipo = :tipo");
//		q.setParameter("login", login);
//		q.setParameter("senha", senha);
//		q.setParameter("tipo", 0); //1 -> administrador
//		
//		try {
//			return (Usuario) q.getSingleResult();
//		} catch (Exception ex) {
//			return null;
//		}
//	}

}
