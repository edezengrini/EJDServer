package server.enumerations;

import server.entities.Estado;
import server.entities.interfaces.IEnumEntidade;
import arquitetura.common.util.IClasseRevisao;

public enum EnumEstado implements IEnumEntidade<Estado>, IClasseRevisao{

	RONDONIA(new Estado(11L,"RO","Rond�nia")),
	ACRE(new Estado(12L,"AC","Acre")),
	AMAZONAS(new Estado(13L,"AM","Amazonas")),
	RORAIMA(new Estado(14L,"RR","Roraima")),
	PARA(new Estado(15L,"PA","Par�")),
	AMAPA(new Estado(16L,"AP","Amap�")),
	TOCANTINS(new Estado(17L,"TO","Tocantins")),
	
	MARANHAO(new Estado(21L,"MA","Maranh�o")),
	PIAUI(new Estado(22,"PI","Piau�")),
	CEARA(new Estado(23,"CE","Cear�")),
	RIO_GRANDE_DO_NORTE(new Estado(24L,"RN","Rio Grande do Norte")),
	PARAIBA(new Estado(25L,"PB","Para�ba")),
	PERNAMBUCO(new Estado(26L,"PE","Pernambuco")),
	ALAGOAS(new Estado(27L,"AL","Alagoas")),
	SERGIPE(new Estado(28L,"SE","Sergipe")),
	BAHIA(new Estado(29L,"BA","Bahia")),

	MINAS_GERAIS(new Estado(31L,"MG","Minas Gerais")),
	ESPIRITO_SANTO(new Estado(32L,"ES","Esp�rito Santo")),
	RIO_DE_JANEIRO(new Estado(33L,"RJ","Rio de Janeiro")),
	SAO_PAULO(new Estado(35L,"SP","S�o Paulo")),
	
	PARANA(new Estado(41L,"PR","Paran�")),
	SANTA_CATARINA(new Estado(42L,"SC","Santa Catarina")),
	RIO_GRANDE_DO_SUL(new Estado(43L,"RS","Rio Grande do Sul")),

	MATO_GROSSO_SUL(new Estado(50L,"MS","Mato Grosso do Sul")),
	MATO_GROSSO(new Estado(51L,"MT","Mato Grosso")),
	GOIAS(new Estado(52L,"GO","Goi�s")),
	DISTRITO_FEDERAL(new Estado(53L,"DF","Distrito Federal")),

	;

	private Estado estado;

	private EnumEstado(Estado estado) {
		this.estado = estado;
	}

    @Override
    public int getRevisao() {
        return 1;
    }

    @Override
    public Estado getEntidade() {
        return estado;
    }

}