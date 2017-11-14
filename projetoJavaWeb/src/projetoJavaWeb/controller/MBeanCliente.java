package projetoJavaWeb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import projetoJavaWeb.DAO.ClienteDAO;
import projetoJavaWeb.entity.Cliente;

@ManagedBean(name = "mBeanCliente")
public class MBeanCliente {

	static ClienteDAO cDAO = new ClienteDAO();
	private List<Cliente> clientes;

	private Integer id;
	private String nome;
	private String cpf;
	private Date dataCadastro;
	private String endereco;
	private String cep;
	private String telefone;

	/* Método para salvar um cliente no banco de dados */
	public void salvar() {
		Cliente c = new Cliente();
		c.setId(id);
		c.setNome(nome);
		c.setCpf(cpf);
		c.setDataCadastro(dataCadastro);
		c.setEndereco(endereco);
		c.setCep(cep);
		c.setTelefone(telefone);

		if (id == null) {
			cDAO.salvar(c);
		} else {
			cDAO.alterar(c);
		}
	}

	/* Método para excluir um cliente do banco de dados */
	public void excluir(Cliente cliente) {
		cDAO.excluir(cliente);
	}

	/* Método para */
	public void alterar(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.dataCadastro = cliente.getDataCadastro();
		this.endereco = cliente.getEndereco();
		this.cep = cliente.getCep();
		this.telefone = cliente.getTelefone();
	}

	/* Método que realiza consulta no banco de dados */
	public List<Cliente> getClientes() {
		return cDAO.consultar();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setClientes(List<Cliente> clientes) {
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
