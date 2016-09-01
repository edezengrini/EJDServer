
package server.entities.interfaces;

import java.io.Serializable;

public interface IEntity extends Serializable{
	
	Long getId();

	void validate() throws Exception;

	boolean equals(IEntity other);
}
