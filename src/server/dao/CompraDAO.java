
package server.dao;

import server.entities.Compra;

public class CompraDAO extends AbstractDAO<Compra>{
	
	public void excluirTudo() throws Exception{
		for(Compra compra: localizarTodos()){
			excluir(compra);
		}
	}
}
