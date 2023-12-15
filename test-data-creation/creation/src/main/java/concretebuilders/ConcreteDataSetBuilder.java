package concretebuilders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.distribution.NormalDistribution;

import builders.DataSetBuilder;
import models.DataSetConfig;
import models.Entity;
import models.Field;

public class ConcreteDataSetBuilder implements DataSetBuilder{
	
	public Map<Integer, Entity> buildDataSetWithRepetitions(DataSetConfig dataSetConfig, Entity entity) {
		Map<Integer, Entity> table = new HashMap<Integer, Entity>();
		table.put(0, entity);
		//TO-DO: Create new method that builds the vec \in {0,...,numRecs} x R^nFields with the chosen indexes
		Integer[][] chosenIndexes = generateIndexes(table, dataSetConfig);
		generateEntitiesFromChosenIndexes(chosenIndexes, table, dataSetConfig);
		return table;
	}

	public Map<Integer, Entity> addNoiseToDataSetWithRepetitions(DataSetConfig dataSetConfig) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void generateEntitiesFromChosenIndexes(Integer[][] chosenIndexes, Map<Integer, Entity> table, DataSetConfig dataSetConfig) {
		LinkedList<LinkedList<String>> catalogMatrix = new LinkedList<LinkedList<String>>();
		String line;
		for (Field f : table.get(0).listOfFields) {
			if (f.getType() == "nombre") {
				String uri = "C:\\\\Users\\\\rodri\\\\PiSolutions\\\\test-data-creation\\\\data\\\\nombres\\\\concatnames.csv";
				LinkedList<String> listOfNames = new LinkedList<String>();
				try {
					FileReader fileReader = new FileReader(uri);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					try {
						while ((line = bufferedReader.readLine()) != null) {
							String[] arrNames = line.split(",");
							listOfNames.add(arrNames[1]);
						}
						catalogMatrix.add(listOfNames);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		for (int i = 1; i < dataSetConfig.getNumberOfRecords(); i++) {
			List<Field> listOfFields = new LinkedList<Field>();
			for (int j = 0; j < table.get(0).listOfFields.size(); j++) {
				Field field = new Field(table.get(0).listOfFields.get(j).getType(), catalogMatrix.get(j).get(chosenIndexes[i][j]));
				listOfFields.add(field);
			}
			Entity iThEntity = new Entity("Check the 0th element of the map for this info.", listOfFields);
			table.put(i, iThEntity);
		}
	}
	
	public Integer[][] generateIndexes(Map<Integer, Entity> table, DataSetConfig dataSetConfig){
		List<Field> nFields = table.get(0).listOfFields;
		List<Integer> nRowsPerFieldInCatalog = new LinkedList<Integer>();
		for (Field f : nFields) {
			if (f.getType() == "nombre") {
				int nLinesInNombreCatalog = obtainNumberOfLinesInCatalog("C:\\Users\\rodri\\PiSolutions\\test-data-creation\\data\\nombres\\concatnames.csv");
				nRowsPerFieldInCatalog.add(nLinesInNombreCatalog);
			}
			// To-Do add more catalogs
		}
		List<NormalDistribution> choosers = generateChoosers(nRowsPerFieldInCatalog);
		Integer[][] arrayOfChosenIndexes = generateFinalIndexes(choosers, dataSetConfig);
		return arrayOfChosenIndexes;
	}
	
	public Integer[][] generateFinalIndexes(List<NormalDistribution> choosers, DataSetConfig dataSetConfig){
		Integer[][] tableOfChosenIndexes = new Integer[dataSetConfig.getNumberOfRecords()][choosers.size()];
		for (int i = 0; i < dataSetConfig.getNumberOfRecords(); i++) {
			// optimization: use multivariate gaussian distribution
			for (int j = 0; j < choosers.size(); j++) {
				tableOfChosenIndexes[i][j] = (int)choosers.get(j).sample();
			}
		}
		return tableOfChosenIndexes;
	}
	
	public List<NormalDistribution> generateChoosers(List<Integer> nRowsPerFieldInCatalog) {
		
		LinkedList<NormalDistribution> listOfChoosers = new LinkedList<NormalDistribution>();
		for (int i : nRowsPerFieldInCatalog) {
			int iThMidPoint = Math.floorDiv(i, 2);
			NormalDistribution iThChooser = new NormalDistribution(iThMidPoint, 5000);
			listOfChoosers.add(iThChooser);
		}
		return listOfChoosers;
	}
	
	public Integer obtainNumberOfLinesInCatalog(String uri) {
		try {
			FileReader fileReader = new FileReader(uri);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int contador = 0;
			try {
				while (bufferedReader.readLine() != null) {
					contador++;
				}
				return(contador);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}
	
}
