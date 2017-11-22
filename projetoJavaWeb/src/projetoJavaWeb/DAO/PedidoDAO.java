package projetoJavaWeb.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoJavaWeb.entity.Pedido;

public class PedidoDAO {
	
	EntityManager em = Conexao.getInstance().createEntityManager();

	public void salvar(Pedido pedido) {
		em.getTransaction().begin();
		em.persist(pedido);
		em.getTransaction().commit();
	}

	public void alterar(Pedido pedido) {
		em.getTransaction().begin();
		em.merge(pedido);
		em.getTransaction().commit();
	}
	
	public void excluir(Pedido pedido) {
		em.getTransaction().begin();
		Pedido p = em.find(Pedido.class, pedido.getId());
		if (p != null) {
			em.remove(p);
		}
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pedido> consultar() {
		Query q = em.createQuery("FROM Pedido");
		return (List<Pedido>) q.getResultList();
	}

	public Pedido buscar(Integer id) {
		Pedido pedido = em.find(Pedido.class, id);
		return pedido;
	}
}
