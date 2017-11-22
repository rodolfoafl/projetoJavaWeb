package projetoJavaWeb.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projetoJavaWeb.DAO.PedidoDAO;
import projetoJavaWeb.DAO.ProdutoDAO;
import projetoJavaWeb.entity.Item;
import projetoJavaWeb.entity.Pedido;
import projetoJavaWeb.entity.Produto;

@ManagedBean(name = "mBeanCarrinho")
@SessionScoped
public class MBeanCarrinho {
	private ArrayList<Item> itens = new ArrayList<Item>();
	
	private BigDecimal valorTotal = BigDecimal.ZERO;
	
	public String salvarPedido() {
		Pedido p = new Pedido();
		p.setDataCompra(Calendar.getInstance());
		p.setItens(itens);
		for (Item i : itens) {
			i.setPedido(p);
		}

		new PedidoDAO().salvar(p);
		return "";
	}
	
	public String cancelarPedido() {
		itens.clear();
		this.setValorTotal();
		return "novaLista.jsf";
	}
	
	public String removerItem(Integer idProduto) {
		Produto produto = new ProdutoDAO().buscar(idProduto);
		Item item = procuraItem(produto);
		if(item != null) {
			itens.remove(item);
		}
		this.setValorTotal();
		return "novoCarrinho.jsf";
	}

	public String adicionarProduto(Integer idProduto) {

		Produto produto = new ProdutoDAO().buscar(idProduto);
		Item item = procuraItem(produto);
		if (item == null) {
			item = new Item();
			item.setProduto(produto);
			item.setQuantidade(1);
			itens.add(item);
		} else {
			item.setQuantidade(item.getQuantidade() + 1);
		}
		this.setValorTotal();

		return "novoCarrinho.jsf";
	}

	public Item procuraItem(Produto produto) {
		for (Item item : itens) {
			if (item.getProduto().getId() == produto.getId()) {
				return item;
			}
		}
		return null;
	}
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal() {
		valorTotal = BigDecimal.ZERO;
		BigDecimal x = BigDecimal.ZERO;
		for(Item i: itens) {
			x = x.add(i.getValorTotal());
		}
		valorTotal = valorTotal.add(x);
	}
	
	public ArrayList<Item> getItens() {
		return itens;
	}
	
	

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
}
