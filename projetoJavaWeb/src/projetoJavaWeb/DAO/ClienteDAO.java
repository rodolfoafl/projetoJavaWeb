package projetoJavaWeb.DAO;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import projetoJavaWeb.entity.Cliente;
import projetoJavaWeb.entity.Pedido;
import projetoJavaWeb.entity.Usuario;

public class ClienteDAO {
	EntityManager em = Conexao.getInstance().createEntityManager();

	public void salvar(Cliente cliente) {
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}

	public void alterar(Cliente cliente) {
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
	}

	public void excluir(Cliente cliente) {
		em.getTransaction().begin();
		Cliente c = em.find(Cliente.class, cliente.getId());
		if (c != null) {
			em.remove(c);
		}
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> consultar() {
		Query q = em.createQuery("FROM Cliente");
		return (List<Cliente>) q.getResultList();
	}

	public Cliente buscar(String email, String senha) {
		Query q = em.createQuery("select c from Cliente c " + "where c.email = :email and c.senha = :senha");
		q.setParameter("email", email);
		q.setParameter("senha", senha);

		try {
			return (Cliente) q.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}
}
