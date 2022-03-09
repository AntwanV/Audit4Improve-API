/**
 * <p>Interfaz que deben implementar todos los informes manejados</p>
 */
package us.muit.fs.a4i.model.daos;

import java.util.Date;

/**
 * @author Isabel Rom�n
 *
 */
public interface Report {
	/**
	 * <p>Devuelve la fecha en la que fu� generado el informe</p>
	 * @return
	 */
	Date getDate();
	/**
	 * <p>Guarda el informe con el nombre asignado</p>
	 * 
	 *  @param id identificador del informe
	 */
	void persist(String id);

}
