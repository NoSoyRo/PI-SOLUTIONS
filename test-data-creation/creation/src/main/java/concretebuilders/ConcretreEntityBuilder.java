package concretebuilders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import builders.EntityBuilder;
import models.Entity;
import models.Field;

public class ConcretreEntityBuilder implements EntityBuilder {

	private InputStream configFile;
	private Properties properties;
	private String fields;
	private List<Field> listOfFieldsSecure;
	
	public Entity buildEntityFromFile(String uri) {
		try {
			configFile = new FileInputStream(uri);
			properties = new Properties();
			try {
				properties.load(configFile);
				fields = properties.getProperty("entity.fields");
				listOfFieldsSecure = createListOfFields(fields);
				Entity entity = new Entity(fields, listOfFieldsSecure);
				return entity;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Field> createListOfFields(String fieldsCSV){
		String[] listOfStringFields = fieldsCSV.split(",");
		List<Field> listOfFields = new LinkedList<Field>();
		for (String i : listOfStringFields) {
			if (i == "nombre") {
				listOfFields.add(new Field(i, null));
			}
			if (i == "apellidoMaterno") {
				listOfFields.add(new Field(i, null));
			}
			if (i == "apellidoPaterno") {
				listOfFields.add(new Field(i, null));
			}
			// TO-DO: Add more field objects.
		}
		return listOfFields;
	}

}
