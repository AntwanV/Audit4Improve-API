/**
 * <p>Algoritmos para el c�lculo de indicadores espec�ficos al tipo de informe</p>
 */
package us.muit.fs.a4i.control;

import us.muit.fs.a4i.model.entities.Indicator;
import us.muit.fs.a4i.model.entities.ReportI;

/**
 * 
 * <p>Define los m�todos para calcular cada indicador y a�adirlo al informe</p>
 * <p>Puede hacerse uno a uno o todos a la vez</p>
 * @author Isabel Rom�n
 *
 */
public interface IndicatorsCalculator {
	/**
	 * Calcula el indicador con el nombre que se pasa
	 * Si las m�tricas que necesita no est�n en el informe las busca y las a�ade
	 * @param name
	 * @param report
	 */
	public void calcIndicator(String name,ReportI report);
	/**
	 * Calcula todos los indicadores descritos
	 * @param report
	 */
	public void calcAllIndicators(ReportI report);
}
