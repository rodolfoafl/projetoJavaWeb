package projetoJavaWeb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import projetoJavaWeb.DAO.ProdutoDAO;
import projetoJavaWeb.entity.Item;
import projetoJavaWeb.entity.Produto;

@ManagedBean(name = "mBeanCarrinho")
@SessionScoped
public class MBeanCarrinho {
	private ArrayList<Item> itens = new ArrayList<Item>();

	public String adicionarProduto(Integer idProduto) {
		
		Produto produto = new ProdutoDAO().buscar(idProduto);
		Item item = procuraItem(produto);
		if(item == null) {
			item = new Item();
			item.setProduto(produto);
			item.setQuantidade(1);
			itens.add(item);
		}else {
			item.setQuantidade(item.getQuantidade() + 1);
		}
		
		return "novoCarrinho.jsf";
	}
	
	public Item procuraItem(Produto produto) {
		for (Item item : itens) {
			if(item.getProduto().getId() == produto.getId()) {
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
