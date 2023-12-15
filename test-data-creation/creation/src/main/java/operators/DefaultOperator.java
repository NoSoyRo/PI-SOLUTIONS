package operators;

import java.util.HashMap;
import java.util.Map;

import builders.DataSetBuilder;
import builders.EntityBuilder;
import models.DataSetConfig;
import models.Entity;

public class DefaultOperator {
	private EntityBuilder entityBuilder;
	private DataSetBuilder dataSetBuilder;
	public EntityBuilder getEntityBuilder() {
		return entityBuilder;
	}
	public void setEntityBuilder(EntityBuilder entityBuilder) {
		this.entityBuilder = entityBuilder;
	}
	public DataSetBuilder getDataSetBuilder() {
		return dataSetBuilder;
	}
	public void setDataSetBuilder(DataSetBuilder dataSetBuilder) {
		this.dataSetBuilder = dataSetBuilder;
	}
	public DefaultOperator(EntityBuilder entityBuilder, DataSetBuilder dataSetBuilder) {
		this.entityBuilder = entityBuilder;
		this.dataSetBuilder = dataSetBuilder;
	}
	// Methods to operate
	public Entity makeEntity(String uri) {
		return new Entity();
	} 
	
	public DataSetConfig makeDataSetConfiguration(Integer numeroRegistros, String tipoDeRuido, String tipoDeRepeticion) {
		return new DataSetConfig();
	} 
	
	public Map<Integer, Entity> makeDataSet(DataSetConfig dataSetConfig, Entity entity) {
		return new HashMap<Integer, Entity>();
	}
	
	
}
