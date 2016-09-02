package server.enumerations;

import arquitetura.common.util.IClasseRevisao;
import server.entities.TipoPessoa;
import server.entities.interfaces.IEnumEntidade;

public enum EnumTipoPessoa implements IEnumEntidade<TipoPessoa>, IClasseRevisao {

    PESSOA_IDFLAGSTATUS_ATIVO(new TipoPessoa(1L, 1L, "Pessoa")),
    PESSOA_IDFLAGSTATUS_INATIVO(new TipoPessoa(2L, 2L, "Pessoa")),

    ;

	private TipoPessoa tipoPessoa;

	EnumTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	@Override
	public int getRevisao() {
		return 1;
	}

	@Override
	public TipoPessoa getEntidade() {
		return tipoPessoa;
	}

}
