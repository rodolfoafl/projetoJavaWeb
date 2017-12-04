package projetoJavaWeb.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import projetoJavaWeb.DAO.CategoriaDAO;
import projetoJavaWeb.entity.Categoria;
import projetoJavaWeb.entity.Cliente;

@ManagedBean(name = "mBeanCategoria")
public class MBeanCategoria {

	private Integer id;
	private String nome;
	
	private List<Categoria> categorias;
	
	public void salvar() {
		Categoria c = new Categoria();
		c.setId(id);
		c.setNome(nome);

		if (id == null) {
			new CategoriaDAO().salvar(c);
		} else {
			new CategoriaDAO().alterar(c);
		}
	}
	
	/* Método para excluir um cliente do banco de dados */
	public void excluir(Categoria c) {
		new CategoriaDAO().excluir(c);
	}

	/* Método para */
	public void alterar(Categoria c) {
		this.id = c.getId();
		this.nome = c.getNome();
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

	public List<Categoria> getCategorias() {
		return new CategoriaDAO().consultar();
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
