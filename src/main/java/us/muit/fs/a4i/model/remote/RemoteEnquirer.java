/**
 * 
 */
package us.muit.fs.a4i.model.remote;

import java.util.List;

import us.muit.fs.a4i.exceptions.MetricException;

import us.muit.fs.a4i.model.entities.Metric;
import us.muit.fs.a4i.model.entities.ReportI;

/**
 * <p>Interfaz para desacoplar el mecanismo de obtenci�n de m�tricas del servidor remoto que se use como fuente de las mismas</p>
 * <p>Un conjunto de m�tricas es espec�fico para un tipo de entidad a informar: organizaci�n, proyecto, repositorio, desarrollador...</p>
 * <p>La identidad se refiere al identificador un�voco de la entidad sobre la que se quiere informar en el servidor remoto, la sem�ntica puede depender del tipo de entidad y del remoto</p>
 * @author IsabelRom�n
 *
 */
public interface RemoteEnquirer{
	
	/**
	 * <p>Construye el informe por defecto sobre la entidad indicada</p>
	 * @param entityId Identificador un�voco en el remoto de la entidad sobre la que se quiere informar.
	 * @return
	 */
	
	public ReportI buildReport(String entityId);
	/**
	 * <p>Consulta una m�trica espec�fica para una entidad concreta</p>
	 * @param metricName m�trica solicitada
	 * @param entityId Identificador un�voco en el remoto de la entidad sobre la que se consulta
	 * @return
	 * @throws MetricException
	 */
	public Metric getMetric(String metricName,String entityId) throws MetricException;

	/**
	 * <p>Devuelve las m�tricas que puede obtener del remoto</p>
	 * @return
	 */
	public List<String> getAvailableMetrics();
}
