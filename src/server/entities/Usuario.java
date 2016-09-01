package server.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

@Entity
public class Usuario extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "USUARIO_IDUSUARIO_GENERATOR", sequenceName = "IDUSUARIO", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_IDUSUARIO_GENERATOR")
    private Long idUsuario;

    private String nome;

    private String email;

    private String login;

    private String senha;

    private byte status = 1;

    private byte permissao = 0;

    private Date dataCadastro;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String nome, String login, String email, boolean ativo, boolean permissao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.setStatus(ativo);
        this.setPermissao(permissao);
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return status == 1;
    }

    public void setStatus(boolean status) {
        this.status = (byte) (status ? 1 : 0);
    }

    public boolean isAdministrador() {
        return permissao == 1;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = (byte) (permissao ? 1 : 0);
    }

    public void setPermissao(byte permissao) {
        this.permissao = permissao;
    }

    @Override
    public Long getId() {
        return this.getIdUsuario();
    }

    @Override
    public void validate() throws EJDLogicException {
        // TODO Auto-generated method stub

    }

    public byte getPermissao() {
        return permissao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }


}
