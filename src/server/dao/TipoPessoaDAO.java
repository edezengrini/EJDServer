
package server.dao;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.TipoPessoa;

@ManagedBean
public class TipoPessoaDAO extends AbstractDAO<TipoPessoa>{

	public void excluirTudo() throws Exception{
		for(TipoPessoa tipoPessoa: localizarTodos()){
			excluir(tipoPessoa);
		}
	}

	public TipoPessoa find(Long id) {
	    StringBuilder sb = new StringBuilder();

	    sb.append(" select tp from TipoPessoa tp ");
	    sb.append(" where ");
	    sb.append("   tp.id = :id ");

	    TypedQuery<TipoPessoa> query = criarQuery(sb.toString());

	    query.setParameter("id", id);

	    return getSingleResult(query);
	}


    public TipoPessoa findByCodigo(Long codigo) {
        StringBuilder sb = new StringBuilder();

        sb.append(" select tp from TipoPessoa tp ");
        sb.append(" where ");
        sb.append("   tp.codigo = :codigo ");

        TypedQuery<TipoPessoa> query = criarQuery(sb.toString());

        query.setParameter("codigo", codigo);

        return getSingleResult(query);
    }

}
