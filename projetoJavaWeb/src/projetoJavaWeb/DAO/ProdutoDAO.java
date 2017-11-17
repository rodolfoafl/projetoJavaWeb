package projetoJavaWeb.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoJavaWeb.entity.Produto;

public class ProdutoDAO {
	EntityManager em = Conexao.getInstance().createEntityManager();

	public void salvar(Produto produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}

	public void alterar(Produto produto) {
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
	}
	
	public void excluir(Produto produto) {
		em.getTransaction().begin();
		Produto p = em.find(Produto.class, produto.getId());
		if (p != null) {
			em.remove(p);
		}
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> consultar() {
		Query q = em.createQuery("FROM Produto");
		return (List<Produto>) q.getResultList();
	}

	public Produto buscar(Integer id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}
}
