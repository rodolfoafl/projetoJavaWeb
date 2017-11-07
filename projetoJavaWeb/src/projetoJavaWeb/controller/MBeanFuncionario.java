package projetoJavaWeb.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import projetoJavaWeb.DAO.FuncionarioDAO;
import projetoJavaWeb.entity.Funcionario;

@ManagedBean(name = "mBeanFuncionario")
public class MBeanFuncionario {

	static FuncionarioDAO fDAO = new FuncionarioDAO();

	// private static ArrayList<Funcionario> funcionarios = new
	// ArrayList<Funcionario>();
	private static List<Funcionario> funcionariosBD;

	private String nome;
	private String cpf;
	// private Integer funcao;
	private BigDecimal salario;

	/* Método para salvar um funcionário no banco de dados */
	public void salvarBanco() {
		Funcionario f = new Funcionario();
		f.setNome(nome);
		f.setCpf(cpf);
		f.setSalario(salario);

		// funcionarios.add(f);
		fDAO.salvar(f);
	}

	/* Método para excluir um funcionário do banco de dados */
	public void excluirBanco(Funcionario funcionario) {
		// funcionarios.remove(funcionario);
		fDAO.excluir(funcionario);
	}

	/* Método que realiza consulta no banco de dados */
	public List<Funcionario> getFuncionariosBD() {
		return fDAO.consulta();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	/* MÉTODOS OBSOLETOS, USADOS COM ARRAYLIST */
	// public void salvar() {
	// Funcionario funcionario = new Funcionario();
	// funcionario.setNome(nome);
	// funcionario.setCpf(cpf);
	// funcionario.setSalario(salario);
	//
	// funcionarios.add(funcionario);
	// }

	// public void excluir(Funcionario funcionario) {
	// funcionarios.remove(funcionario);
	// }

	// /*Método para resetar o arraylist*/
	// public void resetar() {
	// funcionarios.clear();
	// }
	//

	// public ArrayList<Funcionario> getFuncionarios() {
	// return funcionarios;
	// }
	//
	// public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
	// this.funcionarios = funcionarios;
	// }

}
