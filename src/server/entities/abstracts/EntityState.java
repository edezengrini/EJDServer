package server.entities.abstracts;

import java.util.Comparator;

public enum EntityState implements Comparator<EntityState> {	 
	/**
	 * New: Entidade Nova, n�o foi persistida, ap�s ser salva passa para UNMODIFIED
	 */
	NEW(3,"Nova"), 
	/**
	 * Unmodified: Estado ap�s ser salva, ou quando for recuperada do banco, ap�s alterada passa para MODIFIED
	 */
	UNMODIFIED(4,"N�o Modificada"), 
	/**
	 * Modified: Estado da entidade que foi recuperada do banco e foi alterada
	 */
	MODIFIED(2,"Modificada"), 
	
	/**
	 * Deleted: Estado da Entidade que ap�s recuperada do banco foi removida dentro da aplica��o, mas ainda n�o no banco
	 */
	DELETED(1,"Removida");
	
	private String name;
	private Integer ordem;
	
	private EntityState(int ordem,String name) {
		this.ordem = ordem;
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public Integer getOrdem() {
		return ordem;
	}

	@Override
	public int compare(EntityState o1, EntityState o2) {
		return o1.getOrdem().compareTo(o2.getOrdem());
	}
	
	
	
	
}