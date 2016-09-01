package server.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import server.dao.PessoaFisicaDAO;
import server.entities.PessoaFisica;

@LocalBean
@Stateless
public class PessoaFisicaEJB {

	@Inject
	private PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

	public PessoaFisica find(Long idPessoa) {
		return pessoaFisicaDAO.find(idPessoa);
	}

    public PessoaFisica findMaiorIdentificador() {
        return pessoaFisicaDAO.findMaiorIdentificador();
    }
}
