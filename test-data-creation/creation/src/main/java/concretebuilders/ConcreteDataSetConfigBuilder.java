package concretebuilders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import builders.DataSetConfigBuilder;
import models.DataSetConfig;

public class ConcreteDataSetConfigBuilder implements DataSetConfigBuilder {
	private InputStream configFile;
	private Properties properties;
	private Integer numberOfRecords;
	private String typeOfRepetition;
	private String typeOfNoise;
	private DataSetConfig dataSetConfig;
	public DataSetConfig buildDataSetConfigFromProperties(String uri) {
		try {
			configFile = new FileInputStream(uri);
			properties = new Properties();
			try {
				properties.load(configFile);
				numberOfRecords = Integer.parseInt(properties.getProperty("entity.fields"));
				typeOfRepetition = properties.getProperty("dataset.typeOfRepetition");
				typeOfNoise = properties.getProperty("dataset.typeOfNoise");
				dataSetConfig = new DataSetConfig(numberOfRecords, typeOfNoise, typeOfRepetition);
				return dataSetConfig;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void DataSetConfigBuilder() {
	}

}
