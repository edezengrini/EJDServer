package server.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

@Entity
public class UnidadeMedida extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long idUnidadeMedida;

	private String sigla;

	private String descricao;

	@OneToMany(mappedBy = "unidadeMedida")
	private List<Produto> produtoList;

	public UnidadeMedida() {
	}

	public UnidadeMedida(Long idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public UnidadeMedida(long idUnidadeMedida, String sigla, String descricao) {
		this.idUnidadeMedida = idUnidadeMedida;
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public Long getIdUnidadeMedida() {
		return idUnidadeMedida;
	}

	public void setIdUnidadeMedida(Long idUnidadeMedida) {
		this.idUnidadeMedida = idUnidadeMedida;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutoList() {
        return produtoList;
    }

	public void setProdutoList(List<Produto> produtoList) {
        this.produtoList = produtoList;
    }

	@Override
	public Long getId() {
		return getIdUnidadeMedida();
	}

	@Override
	public void validate() throws EJDLogicException {
		// TODO Auto-generated method stub

	}


}
