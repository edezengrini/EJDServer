
package server.dao;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.Estado;

@ManagedBean
public class EstadoDAO extends AbstractDAO<Estado>{

	public void excluirTudo() throws Exception{
		for(Estado estado: localizarTodos()){
			excluir(estado);
		}
	}
	
	public Estado find(Long id) {
	    StringBuilder sb = new StringBuilder();

	    sb.append(" select e from Estado e ");
	    sb.append(" where ");
	    sb.append("   e.id = :id ");

	    TypedQuery<Estado> query = criarQuery(sb.toString());

	    query.setParameter("id", id);

	    return getSingleResult(query);
	}
	
}
