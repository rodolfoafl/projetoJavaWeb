package projetoJavaWeb.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoJavaWeb.entity.Funcionario;

public class FuncionarioDAO {
	EntityManager em = Conexao.getInstance().createEntityManager();

	public void salvar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.persist(funcionario);
		em.getTransaction().commit();
	}

	public void excluir(Funcionario funcionario) {
		em.getTransaction().begin();
		Funcionario f = em.find(Funcionario.class, funcionario.getId());
		if (f != null) {
			em.remove(f);
		}
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> consultar() {
		Query q = em.createQuery("FROM Funcionario");
		return (List<Funcionario>) q.getResultList();
	}
	
	public void alterar(Funcionario funcionario) {
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit();
	}
}
