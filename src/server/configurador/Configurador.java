package server.configurador;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import server.dao.EstadoDAO;
import server.dao.FlagDAO;
import server.dao.MunicipioDAO;
import server.dao.TipoPessoaDAO;
import server.dao.UnidadeMedidaDAO;
import server.entities.Flag;
import server.enumerations.EnumEstado;
import server.enumerations.EnumMunicipio;
import server.enumerations.EnumTipoPessoa;
import server.enumerations.EnumUnidadeMedida;
import arquitetura.common.interfaces.IConfigurador;

import common.base.FlagBase;
import common.base.FlagBean;

@Singleton
@Startup
public class Configurador implements IConfigurador {

	private static final Logger LOGGER = Logger.getLogger(Configurador.class.getName());

	@Inject
	private FlagDAO flagDAO = new FlagDAO();

	@Inject
	private EstadoDAO estadoDAO = new EstadoDAO();

	@Inject
	private MunicipioDAO municipioDAO = new MunicipioDAO();

    @Inject
    private UnidadeMedidaDAO unidadeMedidaDAO = new UnidadeMedidaDAO();
    
    @Inject
    private TipoPessoaDAO tipoPessoaDAO = new TipoPessoaDAO();

	@Override
	public String getIdentificador() {
		return "Configurador EJD";
	}

	@Override
	public void configurar() throws Exception {
        long currentTimeStartMillis = System.currentTimeMillis();
        this.configurarFlags();
        currentTimeStartMillis = logDuration("Flags", currentTimeStartMillis);
        this.configurarEstados();
        currentTimeStartMillis = logDuration("Estados", currentTimeStartMillis);
        this.configurarMunicipios();
        currentTimeStartMillis = logDuration("Municipios", currentTimeStartMillis);
        this.configurarUnidadeMedida();
        currentTimeStartMillis = logDuration("UnidadeMedida", currentTimeStartMillis);
        this.configurarTipoPessoa();
        currentTimeStartMillis = logDuration("UnidadeMedida", currentTimeStartMillis);

	}

	private long logDuration(String func, long currentTimeStartMillis) {
	    long currentTimeMillis = System.currentTimeMillis();
	    float seconds = (currentTimeMillis - currentTimeStartMillis) / 1000f;
	    LOGGER.info(func +" "+ seconds + "s");
	    return currentTimeMillis;
    }

    @SuppressWarnings("unchecked")
	private void configurarFlags() throws Exception {
		FlagBase flagBase = new FlagBase();
		List<FlagBean> list = flagBase.getListOfFlagBean();

		for (FlagBean flagBean : list) {
			Flag flag = new Flag();
			flag.setIdFlag(flagBean.getIdFlag());
			flag.setDescricao(flagBean.getDescricao());
			flag.setNomeEntidade(flagBean.getNomeEntidade());
			flag.setNomeAtributo(flagBean.getNomeAtributo());

			flagDAO.editar(flag);
		}
	}

    @SuppressWarnings("unchecked")
	private void configurarEstados() throws Exception {
		for (EnumEstado enumEstado : EnumEstado.values()) {
			estadoDAO.editar(enumEstado.getEntidade());
		}
	}

    @SuppressWarnings("unchecked")
	private void configurarMunicipios() throws Exception {
		for (EnumMunicipio enumMunicipio: EnumMunicipio.values()) {
			municipioDAO.editar(enumMunicipio.getEntidade());
		}
	}

    @SuppressWarnings("unchecked")
    private void configurarUnidadeMedida() throws Exception {
        for (EnumUnidadeMedida enumUnidadeMedida: EnumUnidadeMedida.values()) {
            unidadeMedidaDAO.editar(enumUnidadeMedida.getEntidade());
        }
    }

    @SuppressWarnings("unchecked")
    private void configurarTipoPessoa() throws Exception {
        for (EnumTipoPessoa enumTipoPessoa: EnumTipoPessoa.values()) {
            tipoPessoaDAO.editar(enumTipoPessoa.getEntidade());
        }
    }

}
