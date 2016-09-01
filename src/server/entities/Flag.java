package server.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

@Entity
@Table(name = "flag")
public class Flag extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long idFlag;

	private String descricao;

	private String nomeEntidade;

	private String nomeAtributo;

	@OneToMany(mappedBy = "flagStatus")
	private List<Produto> produtoList;

	public Flag() {
	}

	public Flag(Long idFlag) {
		this.idFlag = idFlag;
	}

	public Flag(Long idFlag, String descricao, String nomeEntidade, String nomeAtributo) {
		this.idFlag = idFlag;
		this.descricao = descricao;
		this.nomeEntidade = nomeEntidade;
		this.nomeAtributo = nomeAtributo;
	}

	public Long getIdFlag() {
		return idFlag;
	}

	public void setIdFlag(Long idFlag) {
		this.idFlag = idFlag;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNomeEntidade() {
		return nomeEntidade;
	}

	public void setNomeEntidade(String nomeEntidade) {
		this.nomeEntidade = nomeEntidade;
	}

	public String getNomeAtributo() {
		return nomeAtributo;
	}

	public void setNomeAtributo(String nomeAtributo) {
		this.nomeAtributo = nomeAtributo;
	}

	public boolean isIdFlagEquals(Long idFlag){
	    return getIdFlag().longValue() == idFlag.longValue();
	}

	public boolean isIdFlagEquals(BigDecimal idFlag){
        return getIdFlag().longValue() == idFlag.longValue();
    }

	@Override
	public Long getId() {
		return getIdFlag();
	}

	public List<Produto> getProdutoList() {
		return produtoList;
	}

	public void setProdutoList(List<Produto> produtoList) {
		this.produtoList = produtoList;
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
