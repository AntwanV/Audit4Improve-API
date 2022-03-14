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
	public void calcIndicator(String name,ReportI report);
	public void calcAllIndicatos(ReportI report);
}
