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
@Table(name = "saida")
public class Saida extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "SAIDA_IDSAIDA", sequenceName = "IDSAIDA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SAIDA_IDSAIDA")
	private Long idSaida;

	private Long numero;

	@Temporal(TemporalType.DATE)
	private Date dataSaida;

	@Column(nullable = false, precision = 18, scale = 4)
	private BigDecimal quantidade;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProduto")
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

	public Saida() {
	}

	public Long getIdSaida() {
		return idSaida;
	}

	public void setIdSaida(Long idSaida) {
		this.idSaida = idSaida;
	}

	public Date getDataSaida() {
		return this.dataSaida;
	}

	public void setDataSaida(Date dataEntrada) {
		this.dataSaida = dataEntrada;
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

	public Pessoa getPessoa() {
        return pessoa;
    }

	public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

	@Override
	public Long getId() {
		return getIdSaida();
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