package server.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import server.dao.UnidadeMedidaDAO;
import server.entities.UnidadeMedida;

@LocalBean
@Stateless
public class UnidadeMedidaEJB {

	@Inject
	private UnidadeMedidaDAO unidadeMedidaDAO;

	public UnidadeMedida find(Long idUnidadeMedida) {
		unidadeMedidaDAO = new UnidadeMedidaDAO();
		return unidadeMedidaDAO.find(idUnidadeMedida);
	}

    public UnidadeMedida findBySigla(String sigla) {
        unidadeMedidaDAO = new UnidadeMedidaDAO();
        return unidadeMedidaDAO.findBySigla(sigla);
    }
}
