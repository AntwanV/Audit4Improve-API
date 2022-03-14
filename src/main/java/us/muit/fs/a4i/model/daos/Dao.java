/**
 * 
 */
package us.muit.fs.a4i.model.daos;

import us.muit.fs.a4i.control.ReportManager;
import us.muit.fs.a4i.model.daos.exceptions.UnknownEntityException;

/**
 * <p>Esta interfaz declara un modo gen�rico de manejo de la persistencia de entidades del tipo T</p>
 * <p>B�sicamente declara operaciones CRUD (crear, leer, actualizar y borrar la entidad)</p>
 * @author Isabel Rom�n
 * @version 0.0
 *
 */
public interface Dao<T> {
	/**
	 * Lee del remoto la entidad de tipo T correspondiente al identificador pasado como par�metro
	 * @param id identificador un�voco de la entidad buscada
	 * @return Entidad creada
	 */
	public T create(String id);
	
	/**
	 * Operaci�n de escritura
	 * Persiste localmente la entidad T pasada como par�metro
	 * @param t entidad a persistir
	 */
	public void save (T t);

	/**
	 * Operaci�n de borrado
	 * Elimina localmente la entidad pasada como par�metro
	 * @param t entidad a eliminar
	 */
	public void delete (T t);
	/**
	 * Operaci�n de borrado
	 * Elimina del repositorio la entidad cuyo identificador un�voco corresponde con el par�metro
	 * @param id identificador un�voco de la entidad a borrar
	 */
	public void delete (String id);
	
	public void setRemoteBuilder(RemoteBuilder<T> constructor);
	public void setReportManager(ReportManager reportmanager);
}