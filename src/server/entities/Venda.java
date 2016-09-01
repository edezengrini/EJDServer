package server.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;
import arquitetura.common.exception.EnumEJDException;


@Entity
@Table(name = "venda")
public class Venda extends AbstractEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1 , name = "VENDA_IDVENDA", sequenceName = "IDVENDA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VENDA_IDVENDA")
	private Long idVenda;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataVenda;

	@Column(nullable = false, precision = 18, scale = 4)
	private BigDecimal quantidade;

	// bi-directional many-to-one association to Produto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproduto")
	private Produto produto;


	public Venda() {
	}

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Date getDataVenda() {
		return this.dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public Long getId() {
		return getIdVenda();
	}

	@Override
	public void validate() throws EJDLogicException {
		if(getProduto() == null){
			throw new EJDLogicException(EnumEJDException.CAMPO_OBRIGATORIO, "Produto");
		}
		if(getQuantidade() == null){
			throw new EJDLogicException(EnumEJDException.CAMPO_OBRIGATORIO, "Quantidade");
		}
	}

//	@Override
//	public boolean equals(IEntity other) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}