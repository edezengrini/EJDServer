package server.dao;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.PessoaFisica;

@ManagedBean
public class PessoaFisicaDAO extends AbstractDAO<PessoaFisica> {

    public PessoaFisica find(Long id) {
        StringBuilder sb = new StringBuilder();

        sb.append(" select pf from PessoaFisica pf ");
        sb.append(" where ");
        sb.append("   pf.idPessoaFisica = :id ");

        TypedQuery<PessoaFisica> query = criarQuery(sb.toString());

        query.setParameter("id", id);

        return getSingleResult(query);
    }

    public PessoaFisica findMaiorIdentificador() {
        StringBuilder sb = new StringBuilder();

        sb.append(" select pf from PessoaFisica pf ");
        sb.append(" order by pf.idPessoaFisica desc");

        TypedQuery<PessoaFisica> query = criarQuery(sb.toString());

        query.setMaxResults(1);

        return getSingleResult(query);
    }
}
