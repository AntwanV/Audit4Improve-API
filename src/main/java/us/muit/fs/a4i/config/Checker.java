/**
 * 
 */
package us.muit.fs.a4i.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.logging.Logger;

import javax.json.*;

/**
 * <p>
 * Clase para verificar las m�tricas e indicadores
 * </p>
 * <p>
 * La API incluye sus m�tricas e indicadores por defecto en la carpeta
 * resources, en el fichero a4iDefault.json
 * </p>
 * <p>
 * Si la aplicaci�n cliente crea nuevas m�tricas o indicadores las guarda en un
 * fichero json de configuraci�n, que tendr� que indic�rsele al Checker
 * </p>
 * <p>
 * Deuda t�cnica: analizar la posibilidad de leer s�lo una vez y mantener en
 * memoria
 * </p>
 * 
 * @author Isabel Rom�n
 *
 */
public class Checker {
	private static Logger log = Logger.getLogger(Checker.class.getName());
	private String a4iMetrics = "a4iDefault.json";
	private String appMetrics = null;

	public void setAppMetrics(String appMetricsPath) {
		appMetrics = appMetricsPath;
	}

	/**
	 * <p>
	 * Comprueba si la m�trica est� definida en el fichero por defecto o en el de la
	 * aplicaci�n cliente
	 * </p>
	 * <p>
	 * Tambi�n verifica que el tipo es el adecuado
	 * </p>
	 * 
	 * @param metricName nombre de la m�trica que se quiere comprobar
	 * @param metricType tipo de la m�trica
	 * @return metricDefinition Si la m�trica est� definida y el tipo es correcto se devuelve un mapa con las unidades y la descripci�n
	 * @throws FileNotFoundException Si no se localiza el fichero de configuraci�n
	 */
	public HashMap<String,String> definedMetric(String metricName, String metricType) throws FileNotFoundException {
		log.info("Checker solicitud de b�squeda m�trica " + metricName);
		
		HashMap<String,String> metricDefinition=null;
		String fileName = getClass().getClassLoader().getResource(a4iMetrics).getFile();
		log.info("Buscando el archivo " + fileName);

		metricDefinition = isDefinedMetric(metricName, metricType, fileName);
		if ((metricDefinition==null) && appMetrics != null) {
			metricDefinition = isDefinedMetric(metricName, metricType, appMetrics);
		}

		return metricDefinition;
	}

	private HashMap<String,String> isDefinedMetric(String metricName, String metricType, String filePath)
			throws FileNotFoundException {
		
		HashMap<String,String> metricDefinition=null;

		FileInputStream is = new FileInputStream(filePath);
		log.info("Creo el inputStream");
		JsonReader reader = Json.createReader(is);
		log.info("Creo el JsonReader");

		JsonObject confObject = reader.readObject();
		log.info("Leo el objeto");
		reader.close();

		log.info("Muestro la configuraci�n le�da " + confObject);
		JsonArray metrics = confObject.getJsonArray("metrics");
		log.info("El n�mero de m�tricas es " + metrics.size());
		for (int i = 0; i < metrics.size(); i++) {
			log.info("nombre: " + metrics.get(i).asJsonObject().getString("name"));
			if (metrics.get(i).asJsonObject().getString("name").equals(metricName)) {
				log.info("Localizada la m�trica");
				log.info("tipo: " + metrics.get(i).asJsonObject().getString("type"));
				if (metrics.get(i).asJsonObject().getString("type").equals(metricType)) {
					metricDefinition=new HashMap<String,String>();
					metricDefinition.put("description", metrics.get(i).asJsonObject().getString("description"));
					metricDefinition.put("unit", metrics.get(i).asJsonObject().getString("unit"));
				}

			}
		}

		return metricDefinition;
	}

	/**
	 * <p>
	 * Comprueba si el indicador est� definido en el fichero por defecto o en el de
	 * la aplicaci�n cliente
	 * </p>
	 * <p>
	 * Tambi�n verifica que el tipo es el adecuado
	 * </p>
	 * 
	 * @param indicatorName nombre del indicador que se quiere comprobar
	 * @param indicatorType tipo del indicador
	 * @return indicatorDefinition Si el indicador est� definido y el tipo es correcto se devuelve un mapa con las unidades y la descripci�n
	 * @throws FileNotFoundException Si no se localiza el fichero de configuraci�n
	 */
	public HashMap<String,String> definedIndicator(String indicatorName, String indicatorType) throws FileNotFoundException {
		HashMap<String,String> indicatorDefinition=null;
		log.info("Checker solicitud de b�squeda indicador " + indicatorName);
		boolean defined = false;
		String fileName = getClass().getClassLoader().getResource(a4iMetrics).getFile();
		log.info("Buscando el archivo " + fileName);
		indicatorDefinition = isDefinedIndicator(indicatorName, indicatorType, fileName);
		if ((indicatorDefinition==null) && appMetrics != null) {
			indicatorDefinition = isDefinedIndicator(indicatorName, indicatorType, appMetrics);
		}

		return indicatorDefinition;
	}

	private  HashMap<String,String> isDefinedIndicator(String indicatorName, String indicatorType, String filePath)
			throws FileNotFoundException {
		HashMap<String,String> indicatorDefinition=null;
		FileInputStream is = new FileInputStream(filePath);
		log.info("Creo el inputStream");
		JsonReader reader = Json.createReader(is);
		log.info("Creo el JsonReader");

		JsonObject confObject = reader.readObject();
		log.info("Leo el objeto");
		reader.close();

		log.info("Muestro la configuraci�n le�da " + confObject);
		JsonArray indicators = confObject.getJsonArray("indicators");
		log.info("El n�mero de indicadores es " + indicators.size());
		for (int i = 0; i < indicators.size(); i++) {
			log.info("nombre: " + indicators.get(i).asJsonObject().getString("name"));
			if (indicators.get(i).asJsonObject().getString("name").equals(indicatorName)) {
				log.info("Localizado el indicador");
				log.info("tipo: " + indicators.get(i).asJsonObject().getString("type"));
				if (indicators.get(i).asJsonObject().getString("type").equals(indicatorType)) {
					indicatorDefinition=new HashMap<String,String>();
					indicatorDefinition.put("description", indicators.get(i).asJsonObject().getString("description"));
					indicatorDefinition.put("unit", indicators.get(i).asJsonObject().getString("unit"));
				}

			}
		}

		return indicatorDefinition;
	}
}
