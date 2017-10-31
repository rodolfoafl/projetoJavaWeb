package projeto.DAO;

import javax.persistence.EntityManager;

import projeto.Entidades.Funcionario;

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
		if(f != null) {
			em.remove(f);
		}
		em.getTransaction().commit();
	}

}
