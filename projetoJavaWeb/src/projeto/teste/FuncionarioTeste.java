package projeto.teste;

import org.junit.Test;

import projetoJavaWeb.DAO.FuncionarioDAO;
import projetoJavaWeb.entity.Funcionario;

public class FuncionarioTeste {
	
	@Test
	public void salvarFuncionario() {
		Funcionario f = new Funcionario();
		f.setNome("Rodolfo");
		
		FuncionarioDAO fDAO = new FuncionarioDAO();
		fDAO.salvar(f);
		
		System.out.println(f.getId());
	}
}
