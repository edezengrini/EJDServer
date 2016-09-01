
package server.dao;

import server.entities.Saida;

public class SaidaDAO extends AbstractDAO<Saida>{

	public void excluirTudo() throws Exception{
		for(Saida saida: localizarTodos()){
			excluir(saida);
		}
	}
}
