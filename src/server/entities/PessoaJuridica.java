package server.entities;

import java.io.Serializable;

import javax.persistence.Entity;

import arquitetura.common.exception.EJDLogicException;

@Entity
public class PessoaJuridica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String razaoSocial;

    private String nomeFantasia;

    private String cnpj;

    private String ie;

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

    public void validate() throws EJDLogicException {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isFisica() {
        return false;
    }

    @Override
    public boolean isJuridica() {
        return true;
    }
}
