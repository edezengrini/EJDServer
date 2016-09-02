package server.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import arquitetura.common.exception.EJDLogicException;
import server.entities.abstracts.AbstractEntity;

@Entity
public class PessoaJuridica  extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(allocationSize = 1, name = "PESSOAJURIDICA_IDPESSOAJURIDICA", sequenceName = "IDPESSOAJURIDICA")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "PESSOAJURIDICA_IDPESSOAJURIDICA")
    private Long idPessoaJuridica;
    
    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private String ie;
    
    public Long getIdPessoaJuridica() {
        return idPessoaJuridica;
    }
    
    public void setIdPessoaJuridica(Long idPessoaJuridica) {
        this.idPessoaJuridica = idPessoaJuridica;
    }
//    
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoaJuridica")
//    private Pessoa pessoa;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
//    
//    public Pessoa getPessoa() {
//        return pessoa;
//    }
//    
//    public void setPessoa(Pessoa pessoa) {
//        this.pessoa = pessoa;
//    }

    public void validate() throws EJDLogicException {
        // TODO Auto-generated method stub
    }

    public boolean isFisica() {
        return false;
    }

    public boolean isJuridica() {
        return true;
    }

    @Override
    public Long getId() {
        return getIdPessoaJuridica();
    }
}
