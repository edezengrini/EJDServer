package server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

@Entity
@Table(name = "pessoa")
public abstract class Pessoa extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(allocationSize = 1, name = "PESSOA_IDPESSOA", sequenceName = "IDPESSOA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_IDPESSOA")
    private Long idPessoa;

    private String fone;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public PessoaFisica getPessoaFisica() {
        return isFisica() ? (PessoaFisica) this : null;
    }

    public PessoaJuridica getPessoaJuridica() {
        return isJuridica() ? (PessoaJuridica) this : null;
    }

    public abstract boolean isFisica();

    public abstract boolean isJuridica();


    @Override
    public Long getId() {
        return getIdPessoa();
    }

    @Override
    public void validate() throws EJDLogicException {
        // TODO Auto-generated method stub
    }

}
