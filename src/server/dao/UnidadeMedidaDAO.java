
package server.dao;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.UnidadeMedida;

@ManagedBean
public class UnidadeMedidaDAO extends AbstractDAO<UnidadeMedida>{

	public void excluirTudo() throws Exception{
		for(UnidadeMedida unidadeMedida: localizarTodos()){
			excluir(unidadeMedida);
		}
	}

	public UnidadeMedida find(Long id) {
	    StringBuilder sb = new StringBuilder();

	    sb.append(" select um from UnidadeMedida um ");
	    sb.append(" where ");
	    sb.append("   um.id = :id ");

	    TypedQuery<UnidadeMedida> query = criarQuery(sb.toString());

	    query.setParameter("id", id);

	    return getSingleResult(query);
	}


    public UnidadeMedida findBySigla(String sigla) {
        StringBuilder sb = new StringBuilder();

        sb.append(" select um from UnidadeMedida um ");
        sb.append(" where ");
        sb.append("   um.sigla = :sigla ");

        TypedQuery<UnidadeMedida> query = criarQuery(sb.toString());

        query.setParameter("sigla", sigla);

        return getSingleResult(query);
    }

}
