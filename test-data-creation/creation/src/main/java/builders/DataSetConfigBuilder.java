package builders;

import models.DataSetConfig;

public interface DataSetConfigBuilder {
	public DataSetConfig buildDataSetConfigFromProperties(String uri);
}
