package server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

@Entity
public class Estado extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long idEstado;

	private String uf;

	private String descricao;

//	@OneToMany(mappedBy = "estado")
//	private List<Municipio> municipioList;

	public Estado() {
	}

	public Estado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Estado(long idEstado, String uf, String descricao) {
		this.idEstado = idEstado;
		this.uf = uf;
		this.descricao = descricao;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public List<Municipio> getMunicipio() {
//		return municipioList;
//	}
//
//	public void setMunicipio(List<Municipio> municipioList) {
//		this.municipioList = municipioList;
//	}

	@Override
	public Long getId() {
		return getIdEstado();
	}

	@Override
	public void validate() throws EJDLogicException {
		// TODO Auto-generated method stub

	}


}
