package server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import arquitetura.common.exception.EJDLogicException;
import server.entities.abstracts.AbstractEntity;

@Entity
@Table(name = "pessoa")
public class Pessoa extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(allocationSize = 1, name = "PESSOA_IDPESSOA", sequenceName = "IDPESSOA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PESSOA_IDPESSOA")
    private Long idPessoa;

    private String fone;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private Flag flagStatus;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoaFisica")
    private PessoaFisica pessoaFisica;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPessoaJuridica")
    private PessoaJuridica pessoaJuridica;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPessoa")
    private TipoPessoa tipoPessoa;

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
    
    public Flag getFlagStatus() {
        return flagStatus;
    }
    
    public void setFlagStatus(Flag flagStatus) {
        this.flagStatus = flagStatus;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
    
    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }
    
    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

//    public PessoaFisica getPessoaFisica() {
//        return isFisica() ? new PessoaFisica() : null;
//    }
//
//    public PessoaJuridica getPessoaJuridica() {
//        return isJuridica() ? new PessoaJuridica() : null;
//    }

//    public boolean isFisica() {
    
//    }
//
//    public boolean isJuridica();


    @Override
    public Long getId() {
        return getIdPessoa();
    }

    @Override
    public void validate() throws EJDLogicException {
        
    }

}
