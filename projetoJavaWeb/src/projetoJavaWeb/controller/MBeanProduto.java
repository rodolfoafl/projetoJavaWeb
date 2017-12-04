package projetoJavaWeb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.catalina.core.ApplicationPart;

import projetoJavaWeb.DAO.ProdutoDAO;
import projetoJavaWeb.entity.Categoria;
import projetoJavaWeb.entity.Produto;

@ManagedBean(name = "mBeanProduto")
public class MBeanProduto {

	static ProdutoDAO pDAO = new ProdutoDAO();

	private List<Produto> produtos;

	private Integer id;
	private String nome;
	private BigDecimal valor;
	private String descricao;
	
	private String categoria;
	
	private ApplicationPart imagem;

	/* Método para salvar um produto no banco de dados */
	public void salvar() {

		String caminhoImagem = "";

		if (imagem != null && imagem.getSubmittedFileName() != null) {
			caminhoImagem = "c:\\imagens\\" + imagem.getSubmittedFileName();
			try {
				byte[] bytesImagem = new byte[(int) imagem.getSize()];
				imagem.getInputStream().read(bytesImagem);
				File f = new File(caminhoImagem);
				FileOutputStream fos = new FileOutputStream(f);
				fos.write(bytesImagem);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		Produto p = new Produto();
		p.setId(id);
		p.setNome(nome);
		p.setValor(valor);
		p.setCaminhoImagem(caminhoImagem);
		p.setDescricao(descricao);
		p.setCategoria(categoria);

		if (id == null) {
			pDAO.salvar(p);
		} else {
			pDAO.alterar(p);
		}
	}

	/* Método para excluir um produto do banco de dados */
	public void excluir(Produto produto) {
		try {
			pDAO.excluir(produto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não é possível excluir o produto!", ""));
		}
	}

	/* Método para */
	public void alterar(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		this.descricao = produto.getDescricao();
		this.categoria = produto.getCategoria();
	}
	
	public String carregarProduto(Produto produto){
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.valor = produto.getValor();
		this.descricao = produto.getDescricao();
		this.categoria = produto.getCategoria();
		
		return "detalhesProduto.jsf";
	}

	/* Método que realiza consulta no banco de dados */
	public List<Produto> getProdutos() {
		return pDAO.consultar();
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public ApplicationPart getImagem() {
		return imagem;
	}

	public void setImagem(ApplicationPart imagem) {
		this.imagem = imagem;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
