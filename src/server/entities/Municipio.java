package server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

@Entity
public class Municipio extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@SequenceGenerator(allocationSize = 1, name = "MUNICIPIO_IDMUNICIPIO", sequenceName = "IDMUNICIPIO")
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "MUNICIPIO_IDMUNICIPIO")
	private Long idMunicipio;

	private Long codigo;
	private Long idEstado;
	private String descricao;

//	@ManyToOne(fetch = FetchType.LAZY)
//	private Estado estado;

	public Municipio() {
	}

	public Municipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Municipio(long idMunicipio, long idEstado, long codigoMunicipio, String descricao) {
		this.idMunicipio = idMunicipio;
		this.idEstado = idEstado;
		this.codigo = codigoMunicipio;
		this.descricao = descricao;
	}

	public Municipio(long idEstado, long codigoMunicipio, String descricao) {
		this.idEstado = idEstado;
		this.codigo = codigoMunicipio;
		this.descricao = descricao;
		this.idMunicipio = codigoMunicipio;
	}

	public Long getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Long idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigoMunicipio) {
		this.codigo = codigoMunicipio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public Estado getEstado() {
//		return estado;
//	}
//
//	public void setEstado(Estado estado) {
//		this.estado = estado;
//	}

	@Override
	public Long getId() {
		return getIdMunicipio();
	}

	@Override
	public void validate() throws EJDLogicException {
		// TODO Auto-generated method stub

	}


}
