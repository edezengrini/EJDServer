package server.entities.abstracts;

import java.io.Serializable;

public class AbstractState implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long clientId;
	
	private EntityState entityState = EntityState.UNMODIFIED;
	
	public Long getClientId() {
		return clientId;
	}
	
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	
	public EntityState getEntityState() {
		return entityState;
	}

	public void setEntityState(EntityState newEntityState) {
		this.entityState = newEntityState;
	}
	
	public boolean isNew(){
		return entityState != null && entityState == EntityState.NEW;
	}
	
	public boolean isModified(){
		return entityState != null && entityState == EntityState.MODIFIED;
	}
	
	public boolean isDeleted(){
		return entityState != null && entityState == EntityState.DELETED;
	}
	
	public boolean isUnmodified(){
		return entityState != null && entityState == EntityState.UNMODIFIED;
	}
}
