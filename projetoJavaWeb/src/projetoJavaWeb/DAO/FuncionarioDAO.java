package projetoJavaWeb.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoJavaWeb.entity.Funcionario;

public class FuncionarioDAO {
	EntityManager em = Conexao.createEntityManager();

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

	public List<Funcionario> consultar() {
		Query q = em.createQuery("SELECT f FROM Funcionario f");
		List<Funcionario> results = (List<Funcionario>) q.getResultList();
		return results;
	}

	public void alterar(Funcionario funcionario) {
		//em.getTransaction().begin();

		Query query = em.createQuery("update Funcionario set nome = :novoNome" + " where id = :idFuncionario");
		query.setParameter("novoNome", "EDITADO");
		query.setParameter("idFuncionario", funcionario.getId());
		int result = query.executeUpdate();

		//em.getTransaction().commit();
	}
}
