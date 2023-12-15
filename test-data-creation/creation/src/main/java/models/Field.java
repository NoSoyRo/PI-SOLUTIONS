package models;

public class Field {
	private String type;
	private Object value;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public Field(String type, Object value) {
		this.type = type;
		this.value = value;
	}
	public Field() {
	}
}
