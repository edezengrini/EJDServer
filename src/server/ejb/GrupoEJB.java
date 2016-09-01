package server.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import server.dao.GrupoDAO;
import server.entities.Grupo;

@LocalBean
@Stateless
public class GrupoEJB {

	@Inject
	private GrupoDAO grupoDAO = new GrupoDAO();

	public Grupo find(Long idGrupo) {
		return grupoDAO.find(idGrupo);
	}

    public Grupo findMaiorIdentificador() {
        return grupoDAO.findMaiorIdentificador();
    }
}
