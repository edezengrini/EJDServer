package server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import arquitetura.common.exception.EJDLogicException;
import server.entities.abstracts.AbstractEntity;

@Entity
public class TipoPessoa extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long idTipoPessoa;

	private Long codigo;

	private String descricao;

//	@OneToMany(mappedBy = "unidadeMedida")
//	private List<Produto> produtoList;

	public TipoPessoa() {

	}

	public TipoPessoa(Long idUnidadeMedida) {
		this.idTipoPessoa = idUnidadeMedida;
	}

	public TipoPessoa(long idUnidadeMedida, Long codigo, String descricao) {
		this.idTipoPessoa = idUnidadeMedida;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getIdTipoPessoa() {
		return idTipoPessoa;
	}

	public void setIdTipoPessoa(Long idUnidadeMedida) {
		this.idTipoPessoa = idUnidadeMedida;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public Long getId() {
		return getIdTipoPessoa();
	}

	@Override
	public void validate() throws EJDLogicException {
		// TODO Auto-generated method stub

	}


}
