package builders;

import models.Entity;

public interface EntityBuilder {
	
	public Entity buildEntityFromFile(String uri);

}
