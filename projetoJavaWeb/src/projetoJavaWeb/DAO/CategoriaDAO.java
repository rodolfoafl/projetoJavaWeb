package projetoJavaWeb.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoJavaWeb.entity.Categoria;

public class CategoriaDAO {
	EntityManager em = Conexao.getInstance().createEntityManager();

	public void salvar(Categoria categoria) {
		em.getTransaction().begin();
		em.persist(categoria);
		em.getTransaction().commit();
	}

	public void alterar(Categoria categoria) {
		em.getTransaction().begin();
		em.merge(categoria);
		em.getTransaction().commit();
	}

	public void excluir(Categoria categoria) {
		em.getTransaction().begin();
		Categoria p = em.find(Categoria.class, categoria.getId());
		try {
			em.remove(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Categoria> consultar() {
		Query q = em.createQuery("FROM Categoria");
		return (List<Categoria>) q.getResultList();
	}

	public Categoria buscar(Integer id) {
		Categoria categoria = em.find(Categoria.class, id);
		return categoria;
	}
}
