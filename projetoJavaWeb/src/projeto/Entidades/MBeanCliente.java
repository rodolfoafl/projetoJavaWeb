package projeto.Entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "mBeanCliente")
public class MBeanCliente {
	private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	private String nome;
	private String cpf;
	// private Date dataCadastro;
	private String endereco;
	private String cep;
	private String telefone;

	public void salvar() {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setCpf(cpf);
		cliente.setEndereco(endereco);
		cliente.setCep(cep);
		cliente.setTelefone(telefone);

		clientes.add(cliente);
	}
	
	public void excluir(Cliente cliente) {
		clientes.remove(cliente);
	}

	public void resetar() {
		clientes.clear();
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
