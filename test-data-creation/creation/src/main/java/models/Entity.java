package models;

import java.util.List;

public class Entity {
	public String numberOfFields;
	public List<Field> listOfFields;
	public String getNumberOfFields() {
		return numberOfFields;
	}
	public void setNumberOfFields(String numberOfFields) {
		this.numberOfFields = numberOfFields;
	}
	public List<Field> getListOfFields() {
		return listOfFields;
	}
	public void setListOfFields(List<Field> listOfFields) {
		this.listOfFields = listOfFields;
	}
	public Entity(String numberOfFields, List<Field> listOfFields) {
		this.numberOfFields = numberOfFields;
		this.listOfFields = listOfFields;
	}
	public Entity() {
	}
}
