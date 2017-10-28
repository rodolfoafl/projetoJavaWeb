package projeto.Entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "mBeanProduto")
public class MBeanProduto {

	private static ArrayList<Produto> produtos = new ArrayList<Produto>();

	// private Integer codigo;
	private String nome;
	// private Integer tipo;
	private String valor;
	private String imagem;
	private String descricao;

	public void salvar() {
		Produto produto = new Produto();
		produto.setNome(nome);
		produto.setValor(valor);
		produto.setImagem(imagem);
		produto.setDescricao(descricao);

		produtos.add(produto);
	}
	
	public void excluir(Produto produto) {
		produtos.remove(produto);
	}
	
	public void resetar() {
		produtos.clear();
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
