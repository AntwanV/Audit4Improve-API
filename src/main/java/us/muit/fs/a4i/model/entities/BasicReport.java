/**
 * 
 */
package us.muit.fs.a4i.model.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * <p>Aspectos generales de todos los informes</p>
 * <p>Todos incluir�n un conjunto de m�tricas de tipo num�rico y otro de tipo Date</p>
 * @author Isabel Rom�n
 *
 */
public abstract class BasicReport {
	private static Logger log=Logger.getLogger(BasicReport.class.getName());
	/**
	 * <p>Identificador un�voco de la entidad a la que se refire el informe</p>
	 */
	protected String id;
	/**
	 * M�tricas
	 * Conteos b�sicos, m�tricas de tipo num�rico 
	 * */
	 
	private HashMap<String,Metric<Integer>> basicCounts;
	/**
	 * Fechas de inter�s
	 */
		
	private HashMap<String,Metric<Date>> relevantDates;
	/**
	 * Busca si est� la m�trica solicitada en los conjuntos comunes de conteos y fechas
	 * @param name Nombre de la m�trica buscada
	 * @return la m�trica localizada
	 */
	BasicReport(){
		basicCounts=new HashMap<String,Metric<Integer>>();
		relevantDates=new HashMap<String,Metric<Date>>();
		
	}
	BasicReport(String id){
		basicCounts=new HashMap<String,Metric<Integer>>();
		relevantDates=new HashMap<String,Metric<Date>>();
		this.id=id;		
	}

	public Metric getMetricByName(String name) {
		log.info("solicitada m�trica de nombre "+name);
		Metric metric=null;
		
		if (basicCounts.containsKey(name)){
			metric=basicCounts.get(name);
		}else if (relevantDates.containsKey(name)){
				metric=relevantDates.get(name);
			}
		return metric;
	}

	public void addCountMetric(Metric<Integer> met) {
		
		basicCounts.put(met.getName(), met);
		log.info("A�adida m�trica de conteo "+met);

	}
	
	public void addRelevantDate(Metric<Date> met) {
		relevantDates.put(met.getName(), met);
		log.info("A�adida m�trica de fecha "+met);
	}
	abstract public Indicator getIndicator(String name);

	abstract public void calcIndicator(String name);
    public void setId(String id) {
    	this.id=id;
    }
    public String getId() {
    	return id;
    }
	@Override
	public String toString() {
		String repoinfo;
		repoinfo="Informaci�n del Informe:\n - M�tricas de conteo: ";
		for (String clave:basicCounts.keySet()) {
		     repoinfo+="\n Clave: " + clave + basicCounts.get(clave);
		}
		repoinfo+="\n - Fechas relevantes: ";
		for (String clave:relevantDates.keySet()) {
		     repoinfo+="\n Clave: " + clave + relevantDates.get(clave);
		}
		return repoinfo;
	}

}
