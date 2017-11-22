package projetoJavaWeb.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
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

	@SuppressWarnings("deprecation")
	public String salvarPedido() {
		Pedido p = new Pedido();
		p.setData(new Date(10, 10, 2010));
		p.setItens(itens);
		p.setValoFinal();
		for (Item i : itens) {
			i.setPedido(p);
		}

		new PedidoDAO().salvar(p);
		return "";
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
	
	public ArrayList<Item> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
}
