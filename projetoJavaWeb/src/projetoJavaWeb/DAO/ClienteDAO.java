package projetoJavaWeb.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoJavaWeb.entity.Cliente;

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

}
