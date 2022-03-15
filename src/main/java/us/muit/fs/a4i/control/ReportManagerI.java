/**
 * 
 */
package us.muit.fs.a4i.control;

import us.muit.fs.a4i.persistence.PersistenceManager;
import us.muit.fs.a4i.exceptions.ReportNotDefinedException;
import us.muit.fs.a4i.model.entities.ReportI;
import us.muit.fs.a4i.model.remote.RemoteEnquirer;
import us.muit.fs.a4i.persistence.ReportFormater;

/**
 * <p>Interfaz con los m�todos disponibles para manejar informes, independientemente del sistema de persistencia utilizado</p>
 * <p>En las primeras versiones s�lo se guardar�n los informes a local, posteriormente tambi�n se podr�n leer</p>
 * @author Isabel Rom�n
 *
 */
public interface ReportManagerI {
    

	public ReportI getReport();
	/**
	 * <p>Establece el formateador a usar</p>
	 * @param El gestor de formato a utilizar
	 */
	public void setRemoteBuilder(RemoteEnquirer remote);
	public void setPersistenceManager(PersistenceManager persistence);
	public void setFormater(ReportFormater formater);
	public void setIndicatorCalc(IndicatorsCalculator calc);
	
	/**
	 * <p>Persiste el informe que recibe como par�metro, seg�n las reglas del gestor de persistencia y formateador establecidos</p>
	 * @param report
	 */
	public void saveReport(ReportI report);
	/**
	 * <p>Establecer el informe que se quiere crear</p>
	 * @param report
	 * @throws ReportNotDefinedException 
	 */
	public void save() throws ReportNotDefinedException;
	
	/**
	 * <p>Crea un informe para la entidad indicada como par�metro, seg�n las reglas del RemoteBuilder Establecido</p>
	 * <p>El id debe identificar un�vocamente a la entidad en el remoto</p>
	 * @param id Identificador de la entidad a la que se refiere el informe
	 * @return el informe creado
	 */
	public ReportI createReport(String id);
	/**
	 * <p>Borra el informe pasado como par�metro, seg�n las reglas establecidas por el gestor de persistencia</p>
	 * @param report
	 */
	public void deleteReport(ReportI report);
	/**
	 * <p>Borra el informe que se est� manejando actualmente, si la referencia no era nula, seg�n las reglas establecidas por el gestor de persistencia</p>
	 */
	public void deleteReport();
}
