package projetoJavaWeb.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import projetoJavaWeb.DAO.FuncionarioDAO;
import projetoJavaWeb.entity.Funcionario;

@ManagedBean(name = "mBeanFuncionario")
public class MBeanFuncionario {

	static FuncionarioDAO fDAO = new FuncionarioDAO();

	private List<Funcionario> funcionariosBD;

	private Integer id;
	private String nome;
	private String cpf;
	private BigDecimal salario;

	/* Método para salvar um funcionário no banco de dados */
	public void salvarBanco() {
		Funcionario f = new Funcionario();
		f.setId(id);
		f.setNome(nome);
		f.setCpf(cpf);
		f.setSalario(salario);
		
		if(id == null) {
			fDAO.salvar(f);
		}else {
			fDAO.alterar(f);
		}
	}

	/* Método para excluir um funcionário do banco de dados */
	public void excluirBanco(Funcionario funcionario) {
		// funcionarios.remove(funcionario);
		fDAO.excluir(funcionario);
	}

	/*Método para */
	public void alterar(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.salario = funcionario.getSalario();
	}

	/* Método que realiza consulta no banco de dados */
	public List<Funcionario> getFuncionariosBD() {
		return fDAO.consultar();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setFuncionariosBD(List<Funcionario> funcionariosBD) {
		this.funcionariosBD = funcionariosBD;
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
