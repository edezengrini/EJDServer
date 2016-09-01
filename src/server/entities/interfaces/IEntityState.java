package server.entities.interfaces;

import arquitetura.common.persistence.entities.EntityState;

public interface IEntityState {

	Long getClientId();

	void setClientId(Long clientId);

	EntityState getEntityState();

	void setEntityState(EntityState newEntityState);

	boolean isNew();

	boolean isModified();

	boolean isDeleted();

	boolean isUnmodified();

}