package server.enumerations;

import server.entities.Flag;
import server.entities.interfaces.IEnumEntidade;
import arquitetura.common.util.IClasseRevisao;

public enum EnumFlag implements IEnumEntidade<Flag>, IClasseRevisao {

	PRODUTO_IDFLAGSTATUS_ATIVO(new Flag(1L, "Ativo", "Produto", "IDFlagStatus")), PRODUTO_IDFLAGSTATUS_BAIXADO(
			new Flag(2L, "Baixado", "Produto", "IDFlagStatus")),

	;

	private Flag flag;

	EnumFlag(Flag flag) {
		this.flag = flag;
	}

	public Flag getFlag() {
		return flag;
	}

	@Override
	public int getRevisao() {
		return 1;
	}

	@Override
	public Flag getEntidade() {
		return flag;
	}

}
