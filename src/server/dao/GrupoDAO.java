package server.dao;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.Grupo;

@ManagedBean
public class GrupoDAO extends AbstractDAO<Grupo> {

    public Grupo find(Long id) {
        StringBuilder sb = new StringBuilder();

        sb.append(" select g from Grupo g ");
        sb.append(" where ");
        sb.append("   g.idGrupo = :id ");

        TypedQuery<Grupo> query = criarQuery(sb.toString());

        query.setParameter("id", id);

        return getSingleResult(query);
    }

    public Grupo findMaiorIdentificador() {
        StringBuilder sb = new StringBuilder();

        sb.append(" select g from Grupo g ");
        sb.append(" order by g.idGrupo desc");

        TypedQuery<Grupo> query = criarQuery(sb.toString());

        query.setMaxResults(1);

        return getSingleResult(query);
    }
}
