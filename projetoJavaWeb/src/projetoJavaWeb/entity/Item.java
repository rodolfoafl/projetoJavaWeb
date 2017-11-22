package projetoJavaWeb.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Produto produto;
	private Integer quantidade;
	@ManyToOne
	private Pedido pedido;
	@Transient
	private BigDecimal valorTotal = BigDecimal.ZERO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPedido(Pedido p) {
		this.pedido = p;
	}
	
	public BigDecimal getValorTotal() {
		this.setValorTotal();
		return valorTotal;
	}

	public void setValorTotal() {
		BigDecimal x = new BigDecimal(this.getQuantidade().toString());
		this.valorTotal = x.multiply(this.getProduto().getValor());
	}

}
