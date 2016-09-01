package server.enumerations;

import server.entities.UnidadeMedida;
import server.entities.interfaces.IEnumEntidade;
import arquitetura.common.util.IClasseRevisao;

public enum EnumUnidadeMedida implements IEnumEntidade<UnidadeMedida>, IClasseRevisao{

    UNIDADE(new UnidadeMedida(1L,"UN","Unidade")),
    QUILOGRAMA(new UnidadeMedida(2L,"KG","Quilograma")),
    BALDE(new UnidadeMedida(3L,"BD","Balde")),
    PASTILHA(new UnidadeMedida(4L,"PST","Pastilha")),
    BLOCO(new UnidadeMedida(5L,"BL","Bloco")),
    CAIXA(new UnidadeMedida(6L,"CX","Caixa")),
    BOBINA(new UnidadeMedida(7L,"BOB","Bobina")),
    BARRA(new UnidadeMedida(8L,"BR","Barra")),
    BARRICA(new UnidadeMedida(9L,"BRC","Barrica")),
    CABECA(new UnidadeMedida(10L,"CAB","Cabe\u00e7a")),
    CILINDRO(new UnidadeMedida(11L,"CIL","Cilindro")),
    CONJUNTO(new UnidadeMedida(12L,"CJ","Conjunto")),
    CARGA(new UnidadeMedida(13L,"CRG","Carga")),
    DUZIA(new UnidadeMedida(14L,"DZ","D\u00fazia")),
    FARDO(new UnidadeMedida(15L,"FRD","Fardo")),
    FOLHA(new UnidadeMedida(16L,"FL","Folha")),
    FRASCO(new UnidadeMedida(17L,"FR","Frasco")),
    GALAO(new UnidadeMedida(18L,"GL","Gal\u00e3o")),
    GRAMA(new UnidadeMedida(19L,"GR","Grama")),
    HECTARE(new UnidadeMedida(20L,"HA","Hect\u00e1re")),
    HORAS(new UnidadeMedida(21L,"HR","Hora")),
    JOGO(new UnidadeMedida(22L,"JG","Jogo")),
    LITRO(new UnidadeMedida(23L,"LT","Litro")),
    LATA(new UnidadeMedida(24L,"LTA","Lata")),
    CABO(new UnidadeMedida(25L,"CB","Cabo")),
    METRO(new UnidadeMedida(26L,"MT","Metro")),
    METROQUADRADO(new UnidadeMedida(27L,"MT2","Metro Quadrado")),
    METROCUBICO(new UnidadeMedida(28L,"MT3","Metro C\u00fabico")),
    MILHEIRO(new UnidadeMedida(29L,"MIL","Milheiro")),
    MILILITRO(new UnidadeMedida(30L,"ML","Mililitro")),
    PAR(new UnidadeMedida(31L,"PAR","PAR")),
    PECA(new UnidadeMedida(32L,"PC","Pe\u00e7a")),
    PACOTE(new UnidadeMedida(33L,"PCT","Pacote")),
    SACO(new UnidadeMedida(34L,"SCO","Saco")),
    ROLO(new UnidadeMedida(35L,"RL","Rolo")),
    SACA(new UnidadeMedida(36L,"SC","Saca")),
    TUBO(new UnidadeMedida(37L,"TB","Tubo")),
    TONELADA(new UnidadeMedida(38L,"TON","Tonelada")),
    MILIGRAMA(new UnidadeMedida(39L,"MG","Miligrama")),

	;

	private UnidadeMedida unidadeMedida;

	private EnumUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

    @Override
    public int getRevisao() {
        return 1;
    }

    @Override
    public UnidadeMedida getEntidade() {
        return unidadeMedida;
    }

}