package projetoJavaWeb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import projetoJavaWeb.DAO.ClienteDAO;
import projetoJavaWeb.DAO.UsuarioDAO;
import projetoJavaWeb.entity.Cliente;
import projetoJavaWeb.entity.Pedido;
import projetoJavaWeb.entity.Usuario;

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

	private String email;
	private String senha;

	public String login() {

		Cliente c = new ClienteDAO().buscar(email, senha);

		// se o usuário for null ou melhor não for encontrado
		// envio uma mensagem para tela avisando
		if (c == null) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválidos!", ""));
			return "";
		}

		// capture o objeto de request
		// nele é possível recuperar a sessão
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		// adiciono na sessão o usuário que fez o login
		req.getSession().setAttribute("cliente", c);

		// redireciono para tela que ele estava tentando acessar
		return "" + req.getSession().getAttribute("pagina");

	}
	
	public String logout() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		req.getSession().setAttribute("cliente", null);
		return "index.jsf";
	}

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
		c.setEmail(email);
		c.setSenha(senha);

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
		this.email = cliente.getEmail();
		this.senha = cliente.getSenha();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
