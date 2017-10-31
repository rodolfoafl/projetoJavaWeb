package projeto.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetoJavaWeb");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
}
