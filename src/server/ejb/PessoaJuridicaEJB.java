package server.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import server.dao.PessoaJuridicaDAO;
import server.entities.PessoaJuridica;

@LocalBean
@Stateless
public class PessoaJuridicaEJB {

	@Inject
	private PessoaJuridicaDAO pessoaJuridicaDAO = new PessoaJuridicaDAO();

	public PessoaJuridica find(Long idPessoa) {
		return pessoaJuridicaDAO.find(idPessoa);
	}

    public PessoaJuridica findMaiorIdentificador() {
        return pessoaJuridicaDAO.findMaiorIdentificador();
    }
}
