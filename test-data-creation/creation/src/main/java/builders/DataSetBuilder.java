package builders;

import java.util.Map;

import models.DataSetConfig;
import models.Entity;

public interface DataSetBuilder {
	
	public Map<Integer, Entity> buildDataSetWithRepetitions(DataSetConfig dataSetConfig, Entity entity);
	public Map<Integer, Entity> addNoiseToDataSetWithRepetitions(DataSetConfig dataSetConfig);

}
