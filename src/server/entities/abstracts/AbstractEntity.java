package server.entities.abstracts;

import server.entities.interfaces.IEntity;
import arquitetura.common.exception.EJDLogicException;

/**
 * Classe base para todas as entidades
 */

public abstract class AbstractEntity extends AbstractState implements IEntity{

	private static final long serialVersionUID = 1L;

	private EntityState entityState = EntityState.UNMODIFIED;

	public abstract Long getId();

	public abstract void validate() throws EJDLogicException;

	@Override
	public final boolean equals(IEntity other) {
		if (other == null) {
			return false;
		}

		Long myId = getId();
		Long otherId = other.getId();

		if (myId == null || otherId == null) {
			return false;
		}

		return myId.longValue() == otherId.longValue();
	}


	public AbstractEntity() {
	}

	public AbstractEntity(EntityState entityState) {
		this();
		this.setEntityState(entityState);
	}

	@Override
	public int hashCode() {
		Long id = getId();
		return (id == null) ? super.hashCode() : id.hashCode();
	}


	public EntityState getEntityState() {
		return entityState;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[ID:" + getId() + " State:" + getEntityState()+" ClientId: "+getClientId()+" super.hashCode="+super.hashCode()+" ]";
	}
}
