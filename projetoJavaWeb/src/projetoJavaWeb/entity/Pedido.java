package projetoJavaWeb.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Calendar dataCompra;
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<Item> itens;
	
//	private BigDecimal valoFinal = BigDecimal.ZERO;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
//	public BigDecimal calculaValorFinal(Integer quantidade, BigDecimal valor) {
//		valoFinal = valor.multiply(new BigDecimal(quantidade));
//		valoFinal.add(valoFinal);
//		return valoFinal;
//	}
//	
//	public BigDecimal getValoFinal() {
//		return valoFinal;
//	}
//
//	public void setValoFinal() {
//		for(Item i: itens) {
//			valoFinal = calculaValorFinal(i.getQuantidade(), i.getProduto().getValor());
//		}
//	}

	public Calendar getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Calendar dataCompra) {
		this.dataCompra = dataCompra;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
