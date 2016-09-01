package server.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import arquitetura.common.exception.EJDLogicException;
import server.entities.abstracts.AbstractEntity;

@Entity
public class Grupo extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(allocationSize = 1, name = "GRUPO_IDGRUPO", sequenceName = "IDGRUPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GRUPO_IDGRUPO")
    @Column(unique = true, nullable = false)
    private Long idGrupo;

    private Long codigo;

    private String descricao;

    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public Long getId() {
        return getIdGrupo();
    }

    @Override
    public void validate() throws EJDLogicException {
        // TODO Auto-generated method stub

    }


}
