package server.entities;

import java.io.Serializable;
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
@Table(name = "compra")
public class Compra extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "COMPRA_IDCOMPRA", sequenceName = "IDCOMPRA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "COMPRA_IDCOMPRA")
	private Long idCompra;

	@Temporal(TemporalType.DATE)
	private Date dataCompra;

	@Column(nullable = false, precision = 18, scale = 4)
	private BigDecimal quantidade;

	// bi-directional many-to-one association to Produto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idproduto")
	private Produto produto;

	public Compra() {
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Date getDataCompra() {
		return this.dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
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
		return getIdCompra();
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
//		return false;
//	}

}