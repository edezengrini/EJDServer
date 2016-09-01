package server.entities;

import java.io.Serializable;

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

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

/**
 * The persistent class for the estoque database table.
 *
 */
@Entity
@Table(name = "estoque")
public class Estoque extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "ESTOQUE_IDESTOQUE", sequenceName = "IDESTOQUE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTOQUE_IDESTOQUE")
	private Long idEstoque;

	@Column(precision = 18, scale = 4)
	private Long saldo;

	// bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idproduto")
	private Produto produto;

	public Estoque() {
	}

	public Long getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Long idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Long getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public Long getId() {
		return getIdEstoque();
	}

	@Override
	public void validate() throws EJDLogicException {
		// TODO Auto-generated method stub

	}

//	@Override
//	public boolean equals(IEntity other) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}