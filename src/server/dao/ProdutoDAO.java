
package server.dao;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.TypedQuery;

import server.entities.Produto;

@ManagedBean
public class ProdutoDAO extends AbstractDAO<Produto>{

	public void excluirTudo() throws Exception{
		for(Produto produto: localizarTodos()){
			excluir(produto);
		}
	}

	public Produto find(Long id) {
	    StringBuilder sb = new StringBuilder();

	    sb.append(" select p from Produto p ");
//	    sb.append("   inner join p.outraTabela ot ");
	    sb.append(" where ");
	    sb.append("   p.id = :id ");

	    TypedQuery<Produto> query = criarQuery(sb.toString());

	    query.setParameter("id", id);

	    return getSingleResult(query);
	}

    public Produto findMaiorIdentificador() {
        StringBuilder sb = new StringBuilder();

        sb.append(" select p from Produto p ");
        sb.append(" order by p.idProduto desc");

        TypedQuery<Produto> query = criarQuery(sb.toString());

        query.setMaxResults(1);

        return getSingleResult(query);
    }

    public List<Produto> findAllOrderByDescricao(){
        StringBuilder sb = new StringBuilder();

        sb.append(" select p from Produto p ");
        sb.append(" order by p.descricao ");

        TypedQuery<Produto> query = criarQuery(sb.toString());

        return query.getResultList();
    }

}
