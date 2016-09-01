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
@Table(name = "entrada")
public class Entrada extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "ENTRADA_IDENTRADA", sequenceName = "IDENTRADA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ENTRADA_IDENTRADA")
	private Long idEntrada;

	private Long numero;

	@Temporal(TemporalType.DATE)
	private Date dataEntrada;

	@Column(nullable = false, precision = 18, scale = 4)
	private BigDecimal quantidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

	public Entrada() {
	}

	public Long getIdEntrada() {
		return idEntrada;
	}

	public void setIdEntrada(Long idEntrada) {
		this.idEntrada = idEntrada;
	}

	public Date getDataEntrada() {
		return this.dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
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
		return getIdEntrada();
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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

//	@Override
//	public boolean equals(IEntity other) {
//		return false;
//	}

}