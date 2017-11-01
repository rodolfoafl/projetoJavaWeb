package projeto.Entidades;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import projeto.DAO.FuncionarioDAO;

@ManagedBean(name = "mBeanFuncionario")
public class MBeanFuncionario {

	FuncionarioDAO fDAO = new FuncionarioDAO();
	
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	private String nome;
	private String cpf;
	// private Integer funcao;
	private BigDecimal salario;

	/*Método para salvar um funcionário no banco de dados e no arraylist*/
	public void salvarBanco() {
		Funcionario f = new Funcionario();
		f.setNome(nome);
		f.setCpf(cpf);
		f.setSalario(salario);
		
		funcionarios.add(f);
		fDAO.salvar(f);
	}
	
//	public void salvar() {
//		Funcionario funcionario = new Funcionario();
//		funcionario.setNome(nome);
//		funcionario.setCpf(cpf);
//		funcionario.setSalario(salario);
//
//		funcionarios.add(funcionario);
//	}
	
//	public void excluir(Funcionario funcionario) {
//		funcionarios.remove(funcionario);
//	}
	
	/*Método para excluir um funcionário do banco de dados e do arraylist*/
	public void excluirBanco(Funcionario funcionario) {
		funcionarios.remove(funcionario);
		fDAO.excluir(funcionario);
	}
	
	
	/*Método para resetar o arraylist*/
	public void resetar() {
		funcionarios.clear();
	}

	public ArrayList<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
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
	
	

}
