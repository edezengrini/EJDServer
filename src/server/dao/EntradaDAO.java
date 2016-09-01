
package server.dao;

import server.entities.Entrada;

public class EntradaDAO extends AbstractDAO<Entrada>{

	public void excluirTudo() throws Exception{
		for(Entrada entrada: localizarTodos()){
			excluir(entrada);
		}
	}
}
