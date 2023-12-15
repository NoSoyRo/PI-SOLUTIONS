package models;

// Deprecated because of the existence of configuration.properties file

public class DataSetConfig {
	private Integer numberOfRecords;
	private String typeOfNoise;
	private String typeOfRepetition;
	public Integer getNumberOfRecords() {
		return numberOfRecords;
	}
	public void setNumberOfRecords(Integer numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}
	public String getTypeOfNoise() {
		return typeOfNoise;
	}
	public void setTypeOfNoise(String typeOfNoise) {
		this.typeOfNoise = typeOfNoise;
	}
	public String getTypeOfRepetition() {
		return typeOfRepetition;
	}
	public void setTypeOfRepetition(String typeOfRepetition) {
		this.typeOfRepetition = typeOfRepetition;
	}
	public DataSetConfig(Integer numberOfRecords, String typeOfNoise, String typeOfRepetition) {
		this.numberOfRecords = numberOfRecords;
		this.typeOfNoise = typeOfNoise;
		this.typeOfRepetition = typeOfRepetition;
	}
	public DataSetConfig() {
	}
}
