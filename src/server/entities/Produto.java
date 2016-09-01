package server.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

import common.base.FlagBase;


@Entity
@Table(name = "produto")
public class Produto extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "PRODUTO_IDPRODUTO", sequenceName = "IDPRODUTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_IDPRODUTO")
	@Column(unique = true, nullable = false)
	private Long idProduto;

	private Long codigo;

	@Column(nullable = false, length = 80)
	private String descricao;

	@Column(nullable = false, precision = 18, scale = 3)
	private BigDecimal valorUnitarioEntrada;

    @Column(nullable = false, precision = 18, scale = 3)
    private BigDecimal valorUnitarioSaida;

    // bi-directional many-to-one association to Compra
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<Compra> compras;

	// bi-directional many-to-one association to Venda
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	private List<Venda> vendas;

	// bi-directional many-to-one association to Estoque
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "produto", targetEntity = Estoque.class)
	private BigDecimal estoque;

	private BigDecimal estoqueMinimo;

	private BigDecimal estoqueMaximo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status")
	private Flag flagStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUnidadeMedida")
    private UnidadeMedida unidadeMedida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGrupo")
    private Grupo grupo;

    private String codigoBarra;

    @Temporal(TemporalType.DATE)
    private Date dataUltimaCompra;

    public Produto() {
	}

	public Long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(Long idProduto) {

		this.idProduto = idProduto;
	}

	public Long getCodigo() {
        return codigo;
    }

	public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorUnitarioEntrada() {
		return this.valorUnitarioEntrada;
	}

	public void setValorUnitarioEntrada(BigDecimal valorUnitarioEntrada) {
		this.valorUnitarioEntrada = valorUnitarioEntrada;
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

	public BigDecimal getEstoque() {
		return estoque;
	}

	public void setEstoque(BigDecimal estoque) {
		this.estoque = estoque;
	}

	public BigDecimal getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(BigDecimal estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public BigDecimal getEstoqueMaximo() {
        return estoqueMaximo;
    }

    public void setEstoqueMaximo(BigDecimal estoqueMaximo) {
        this.estoqueMaximo = estoqueMaximo;
    }

    public Flag getFlagStatus() {
		return flagStatus;
	}

	public void setFlagStatus(Flag flagStatus) {
		this.flagStatus = flagStatus;
	}

	public boolean isAtivo() {
		return isIdFlagStatus(FlagBase.PRODUTO_IDFLAGSTATUS_ATIVO);
	}

	public boolean isBaixado() {
		return isIdFlagStatus(FlagBase.PRODUTO_IDFLAGSTATUS_BAIXADO);
	}

	public Boolean isIdFlagStatus(Long idFlag) {
		return flagStatus != null && flagStatus.isIdFlagEquals(idFlag);
	}

	public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

	public BigDecimal getValorUnitarioSaida() {
        return valorUnitarioSaida;
    }

    public void setValorUnitarioSaida(BigDecimal valorUnitarioSaida) {
        this.valorUnitarioSaida = valorUnitarioSaida;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Date getDataUltimaCompra() {
        return dataUltimaCompra;
    }

    public void setDataUltimaCompra(Date dataUltimaCompra) {
        this.dataUltimaCompra = dataUltimaCompra;
    }

    @Override
	public Long getId() {
		return getIdProduto();
	}

	@Override
	public void validate() throws EJDLogicException {
//		if (getDescricao() == null || getDescricao().trim().isEmpty()) {
//			throw new EJDLogicException(EnumEJDException.CAMPO_OBRIGATORIO, "Descrição");
//		}
//		if (getValorUnitarioEntrada() == null) {
//			throw new EJDLogicException(EnumEJDException.CAMPO_OBRIGATORIO, "Preço");
//		}
	}

	@Override
	public String toString() {
		return getId() + " - " + getDescricao();
	}

}