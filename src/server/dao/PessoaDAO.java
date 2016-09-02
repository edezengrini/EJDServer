package server.dao;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.Pessoa;

@ManagedBean
public class PessoaDAO extends AbstractDAO<Pessoa> {

    public Pessoa find(Long id) {
        StringBuilder sb = new StringBuilder();

        sb.append(" select p from Pessoa p ");
        sb.append(" where ");
        sb.append("   p.idPessoa = :id ");

        TypedQuery<Pessoa> query = criarQuery(sb.toString());

        query.setParameter("id", id);

        return getSingleResult(query);
    }

    public Pessoa findMaiorIdentificador() {
        StringBuilder sb = new StringBuilder();

        sb.append(" select p from Pessoa p ");
        sb.append(" order by p.idPessoa desc");

        TypedQuery<Pessoa> query = criarQuery(sb.toString());

        query.setMaxResults(1);

        return getSingleResult(query);
    }
    
    public Pessoa findByPessoaFisica(Long id) {
        StringBuilder sb = new StringBuilder();

        sb.append(" select p from Pessoa p ");
        sb.append(" join p.pessoaFisica pf ");
        sb.append(" where ");
        sb.append("   pf.idPessoaFisica = :id ");

        TypedQuery<Pessoa> query = criarQuery(sb.toString());

        query.setParameter("id", id);

        return getSingleResult(query);
    }
}
