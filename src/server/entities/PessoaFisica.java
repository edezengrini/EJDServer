package server.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import arquitetura.common.exception.EJDLogicException;
import server.entities.abstracts.AbstractEntity;

@Entity
public class PessoaFisica extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(allocationSize = 1, name = "PESSOAFISICA_IDPESSOAFISICA", sequenceName = "IDPESSOAFISICA")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "PESSOAFISICA_IDPESSOAFISICA")
    private Long idPessoaFisica;

    private String nome;

    private String genero;

    private Date nascimento;

    private String cpf;

    private String rg;

    private String rgOrgaoEmissor;

    private Date rgEmissao;
    
//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "pessoaFisica")
//    private Pessoa pessoa;
//    
    public Long getIdPessoaFisica() {
        return idPessoaFisica;
    }

    public void setIdPessoaFisica(Long idPessoaFisica) {
        this.idPessoaFisica = idPessoaFisica;
    }

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
        return true;
    }

    public boolean isJuridica() {
        return false;
    }

    @Override
    public Long getId() {
        return getIdPessoaFisica();
    }
}
