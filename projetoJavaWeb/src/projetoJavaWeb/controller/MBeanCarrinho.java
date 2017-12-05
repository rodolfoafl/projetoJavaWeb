package projetoJavaWeb.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import projetoJavaWeb.DAO.PedidoDAO;
import projetoJavaWeb.DAO.ProdutoDAO;
import projetoJavaWeb.entity.Cliente;
import projetoJavaWeb.entity.Item;
import projetoJavaWeb.entity.Pedido;
import projetoJavaWeb.entity.Produto;

@ManagedBean(name = "mBeanCarrinho")
@SessionScoped
public class MBeanCarrinho {
	private ArrayList<Item> itens = new ArrayList<Item>();

	private static ArrayList<Pedido> pedidosCliente = new ArrayList<Pedido>();

	private BigDecimal valorTotal = BigDecimal.ZERO;

	public String salvarPedido() {

		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		Cliente c = (Cliente) req.getSession().getAttribute("cliente");

		Pedido p = new Pedido();
		p.setDataCompra(new Date());
		p.setItens(itens);
		p.setCliente(c);
		for (Item i : itens) {
			i.setPedido(p);
		}

		new PedidoDAO().salvar(p);
		itens.clear();
		return "index.jsf";
	}

	public void buscarPedidosCliente() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		Cliente cliente = (Cliente) req.getSession().getAttribute("cliente");
		if (cliente != null) {

			ArrayList<Pedido> pedidos = new ArrayList<>();
			pedidos = (ArrayList<Pedido>) new PedidoDAO().consultar();
			pedidosCliente.removeAll(pedidos);
			if (!pedidos.isEmpty()) {
				for (Pedido pedido : pedidos) {
					if (pedido.getCliente().getId().equals(cliente.getId())) {
						pedidosCliente.add(pedido);
					}
				}
			}
		}
	}

	public String cancelarPedido() {
		itens.clear();
		this.setValorTotal();
		return "listaProdutos.jsf";
	}

	public String removerItem(Integer idProduto) {
		Produto produto = new ProdutoDAO().buscar(idProduto);
		Item item = procuraItem(produto);
		if (item != null) {
			itens.remove(item);
		}
		this.setValorTotal();
		return "carrinho.jsf";
	}

	public String adicionarProduto(Integer idProduto) throws IOException {

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

		// FacesContext.getCurrentInstance().getExternalContext().redirect("carrinho.jsf");
		return "carrinho.jsf";
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
		for (Item i : itens) {
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

	public ArrayList<Pedido> getPedidosCliente() {
		return pedidosCliente;
	}

	public void setPedidosCliente(ArrayList<Pedido> pedidosCliente) {
		MBeanCarrinho.pedidosCliente = pedidosCliente;
	}
}
