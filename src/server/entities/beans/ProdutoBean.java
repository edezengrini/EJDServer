package server.entities.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Persistence;

import server.entities.Compra;
import server.entities.Estoque;
import server.entities.Venda;
import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;
import arquitetura.common.exception.EnumEJDException;

/**
 * The persistent class for the produto database table.
 * 
 */
public class ProdutoBean extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idProduto;

	private String descricao;

	private Double preco;
	private List<Compra> compras;

	private List<Venda> vendas;

	private Estoque estoque;

	public ProdutoBean(Long idProduto, String descricao, Double preco) {
		super();
		this.idProduto = idProduto;
		this.descricao = descricao;
		this.preco = preco;
	}

	public Long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public Long getId() {
		return getIdProduto();
	}

	@Override
	public void validate() throws EJDLogicException {
		if (getDescricao() == null || getDescricao().trim().isEmpty()) {
			throw new EJDLogicException(EnumEJDException.CAMPO_OBRIGATORIO, "Descrição");
		}
		if (getPreco() == null) {
			throw new EJDLogicException(EnumEJDException.CAMPO_OBRIGATORIO, "Preço");
		}
	}

	@Override
	public String toString() {
		return getId() + " - " + getDescricao();
	}
	
	public Long gerarID(){
		Long id = null;
		
		@SuppressWarnings("unused")
		Persistence persistence;
		
		
		
		return id;
	}
//
//	@Override
//	public boolean equals(IEntity other) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}