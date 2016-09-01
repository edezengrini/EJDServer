package server.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import server.entities.abstracts.AbstractEntity;
import arquitetura.common.exception.EJDLogicException;

@Entity
public class Bairro extends AbstractEntity{

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(allocationSize = 1, name = "BAIRRO_IDBAIRRO", sequenceName = "IDBAIRRO")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BAIRRO_IDBAIRRO")
    private Long idBairro;

    private Long idMunicipio;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Municipio municipio;

    public Bairro() {
    }

    public Bairro(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Bairro(long idMunicipio, long idBairro, String descricao) {
        this.idMunicipio = idMunicipio;
        this.idBairro = idBairro;
        this.descricao = descricao;
    }


    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    public Long getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Long idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public Long getId() {
        return getIdBairro();
    }

    @Override
    public void validate() throws EJDLogicException {
        // TODO Auto-generated method stub

    }



}
