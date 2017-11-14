package projetoJavaWeb.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import projetoJavaWeb.DAO.FuncionarioDAO;
import projetoJavaWeb.DAO.ProdutoDAO;
import projetoJavaWeb.entity.Funcionario;
import projetoJavaWeb.entity.Produto;

@ManagedBean(name = "mBeanProduto")
public class MBeanProduto {

	static ProdutoDAO pDAO = new ProdutoDAO();

	private List<Produto> produtos;

	private Integer id;
	private String nome;
	// private Integer tipo;
	private BigDecimal valor;
//	private String imagem;
	private String descricao;

	/* Método para salvar um produto no banco de dados */
	public void salvar() {
		Produto p = new Produto();
		p.setId(id);
		p.setNome(nome);
		p.setValor(valor);
//		p.setImagem(imagem);
		p.setDescricao(descricao);
		
		if(id == null) {
			pDAO.salvar(p);
		}else {
			pDAO.alterar(p);
		}
	}
	
	/* Método para excluir um produto do banco de dados */
	public void excluir(Produto produto) {
		pDAO.excluir(produto);
	}
	
	/*Método para */
	public void alterar(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
//		this.imagem = produto.getImagem();
		this.descricao = produto.getDescricao();
	}

	/* Método que realiza consulta no banco de dados */
	public List<Produto> getProdutos() {
		return pDAO.consultar();
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

//	public String getImagem() {
//		return imagem;
//	}
//
//	public void setImagem(String imagem) {
//		this.imagem = imagem;
//	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
