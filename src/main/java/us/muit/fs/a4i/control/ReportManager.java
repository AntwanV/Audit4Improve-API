/**
 * 
 */
package us.muit.fs.a4i.control;

import us.muit.fs.a4i.model.entities.BasicReport;

/**
 * <p>Interfaz con los m�todos disponibles para manejar informes, independientemente del sistema de persistencia utilizado</p>
 * <p>En las primeras versiones s�lo se guardar�n los informes a local, posteriormente tambi�n se podr�n leer</p>
 * @author Isabel Rom�n
 *
 */
public interface ReportManager {
	
	/**
	 * <p>Guarda el informe</p>
	 * @param report
	 */
	public void saveReport(BasicReport report);
	public void setReport(BasicReport report);
	/**
	 * <p>Establece el formateador a usar</p>
	 * @param El gestor de formato a utilizar
	 */
	public void setFormater(ReportFormater formater);
	
}
