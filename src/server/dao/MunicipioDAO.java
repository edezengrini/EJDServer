
package server.dao;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.Municipio;

@ManagedBean
public class MunicipioDAO extends AbstractDAO<Municipio>{

	public void excluirTudo() throws Exception{
		for(Municipio municipio: localizarTodos()){
			excluir(municipio);
		}
	}

	public Municipio find(Long id) {
	    StringBuilder sb = new StringBuilder();

	    sb.append(" select m from Municipio m ");
	    sb.append(" where ");
	    sb.append("   m.id = :id ");

	    TypedQuery<Municipio> query = criarQuery(sb.toString());

	    query.setParameter("id", id);

	    return getSingleResult(query);
	}

}
