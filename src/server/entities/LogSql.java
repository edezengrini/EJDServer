package server.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

/**
 * The persistent class for the logsql database table.
 * 
 */
@Entity
public class LogSql extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "LOGSQL_IDLOGSQL_GENERATOR", sequenceName = "IDLOGSQL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOGSQL_IDLOGSQL_GENERATOR")
	private Long idLogSql;

	@Temporal(TemporalType.DATE)
	private Date dataExecucao;

	private String operacao;

	private String tabela;

	private String valores;

	private String usuario;

	public LogSql() {
	}

	public Long getIdLogSql() {
		return this.idLogSql;
	}

	public void setIdLogSql(Long idLogSql) {
		this.idLogSql = idLogSql;
	}

	public Date getDataExecucao() {
		return this.dataExecucao;
	}

	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getValores() {
		return valores;
	}

	public void setValores(String valores) {
		this.valores = valores;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public Long getId() {
		return getIdLogSql();
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