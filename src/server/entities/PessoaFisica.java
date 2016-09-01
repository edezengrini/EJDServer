package server.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import arquitetura.common.exception.EJDLogicException;

@Entity
public class PessoaFisica extends Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;

    private String genero;

    private Date nascimento;

    private String cpf;

    private String rg;

    private String rgOrgaoEmissor;

    private Date rgEmissao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRgOrgaoEmissor() {
        return rgOrgaoEmissor;
    }

    public void setRgOrgaoEmissor(String rgOrgaoEmissor) {
        this.rgOrgaoEmissor = rgOrgaoEmissor;
    }

    public Date getRgEmissao() {
        return rgEmissao;
    }

    public void setRgEmissao(Date rgEmissao) {
        this.rgEmissao = rgEmissao;
    }

    public void validate() throws EJDLogicException {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean isFisica() {
        return true;
    }

    @Override
    public boolean isJuridica() {
        return false;
    }
}
