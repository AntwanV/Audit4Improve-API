/**
 * 
 */
package us.muit.fs.a4i.model.daos;


/**
 * <p>Interfaz para desacoplar el mecanismo de construcci�n de una entidad de informaci�n del servidor remoto que aloja la informaci�n</p>
 * <p>El algoritmo de construcci�n en esta versi�n es: establecer el identificador un�voco del objeto a construir en el servidor e invocar construyeObjeto</p>
 * <p>La identidad se refiera al identificador un�voco del objeto que se quiere construir, la sem�ntica puede depender del tipo</p>
 * @author IsabelRom�n
 *
 */
public interface RemoteBuilder<T> {
	public void setId(String id);
	public T construyeObjeto();
}
