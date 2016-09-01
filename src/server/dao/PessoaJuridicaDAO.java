package server.dao;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.PessoaJuridica;

@ManagedBean
public class PessoaJuridicaDAO extends AbstractDAO<PessoaJuridica> {

    public PessoaJuridica find(Long id) {
        StringBuilder sb = new StringBuilder();

        sb.append(" select pj from PessoaJuridica pj ");
        sb.append(" where ");
        sb.append("   pj.idPessoaJuridica = :id ");

        TypedQuery<PessoaJuridica> query = criarQuery(sb.toString());

        query.setParameter("id", id);

        return getSingleResult(query);
    }

    public PessoaJuridica findMaiorIdentificador() {
        StringBuilder sb = new StringBuilder();

        sb.append(" select pj from PessoaJuridica pf ");
        sb.append(" order by pj.idPessoaJuridica desc");

        TypedQuery<PessoaJuridica> query = criarQuery(sb.toString());

        query.setMaxResults(1);

        return getSingleResult(query);
    }
}
