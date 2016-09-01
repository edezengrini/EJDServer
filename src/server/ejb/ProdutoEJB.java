package server.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import arquitetura.common.exception.EJDLogicException;
import arquitetura.common.exception.EnumEJDException;
import server.dao.ProdutoDAO;
import server.entities.Produto;

@LocalBean
@Stateless
public class ProdutoEJB {

	@Inject
	private ProdutoDAO produtoDAO = new ProdutoDAO();

	public Produto find(Long idProduto) {
		produtoDAO = new ProdutoDAO();
		return produtoDAO.find(idProduto);
	}

    public Produto findMaiorIdentificador() {
        return produtoDAO.findMaiorIdentificador();
    }

    public void validarEstoque(Produto entidade) throws EJDLogicException {
        if (entidade.getEstoqueMinimo() != null && entidade.getEstoqueMaximo() != null && entidade.getEstoqueMinimo().compareTo(entidade.getEstoqueMaximo()) >= 0){
            throw new EJDLogicException(EnumEJDException.CAMPO_MENOR_QUE, "Estoque Mínimo", "Estoque Máximo");
        }
    }

    public void validarValor(Produto entidade) throws EJDLogicException {
        if (entidade.getValorUnitarioEntrada() != null && entidade.getValorUnitarioSaida() != null && entidade.getValorUnitarioEntrada().compareTo(entidade.getValorUnitarioSaida()) >= 0){
            throw new EJDLogicException(EnumEJDException.CAMPO_MENOR_QUE, "Valor Unitário de Entrada", "Valor Unitário de Saída");
        }
    }

}
