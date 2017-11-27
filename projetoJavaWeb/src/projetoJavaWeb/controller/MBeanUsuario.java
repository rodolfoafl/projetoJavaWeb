package projetoJavaWeb.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import projetoJavaWeb.DAO.UsuarioDAO;
import projetoJavaWeb.entity.Usuario;

@ManagedBean(name = "mBeanUsuario")
public class MBeanUsuario {

	private String login;
	private String senha;
	private Integer tipo;
	private Integer id;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String autenticacao(Integer tipo) {

		Usuario usuario;

		if (tipo == 1) {
			usuario = new UsuarioDAO().buscar(login, senha);
		}else {
			usuario = new UsuarioDAO().buscarUsuario(login, senha);
		}

		// se o usuário for null ou melhor não for encontrado
		// envio uma mensagem para tela avisando
		if (usuario == null) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login ou senha inválidos!", ""));
			return "";
		}

		// capture o objeto de request
		// nele é possível recuperar a sessão
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		// adiciono na sessão o usuário que fez o login
		req.getSession().setAttribute("usuario", usuario);

		// redireciono para tela que ele estava tentando acessar
		return "" + req.getSession().getAttribute("pagina");
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}
