/**
 * 
 */
package us.muit.fs.a4i.test.config;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import us.muit.fs.a4i.config.Checker;

/**
 * Test de la clase Checker que verifica las m�tricas e indicadores
 * 
 * @author Isabel Rom�n
 *
 */
class CheckerTest {
	private static Logger log = Logger.getLogger(CheckerTest.class.getName());
	static Checker underTest;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		underTest = new Checker();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link us.muit.fs.a4i.control.Checker#definedMetric(java.lang.String)}.
	 */
	@Test
	void testDefinedMetric() {
		Integer valueOK = Integer.valueOf(3);
		String valueKO = "KO";
		log.info("Busco la m�trica kkk");
		try {
			assertNull(underTest.definedMetric("kkk", valueOK.getClass().getName()),
					"Deber�a ser nulo, la m�trica no est� definida");

			log.info("Busco la m�trica watchers");
			assertNotNull(underTest.definedMetric("watchers", valueOK.getClass().getName()),
					"Deber�a devolver un hashmap, la m�trica est� definida");
			assertNull(underTest.definedMetric("watchers", valueKO.getClass().getName()),
					"Deber�a ser nulo, la m�trica est� definida para Integer");
		} catch (FileNotFoundException e) {
			fail("El fichero est� en la carpeta resources");
			e.printStackTrace();
		}
		underTest.setAppMetrics("pepe");
		try {
			underTest.definedMetric("kkk", valueOK.getClass().getName());
			fail("Deber�a lanzar una excepci�n porque intenta buscar en un fichero que no existe");
		} catch (FileNotFoundException e) {
			log.info("Lanza la excepci�n adecuada, FileNotFoud");
		} catch (Exception e) {
			fail("Lanza la excepci�n equivocada " + e);
		}

	}

	/**
	 * Test method for
	 * {@link us.muit.fs.a4i.control.Checker#definedIndicator(java.lang.String)}.
	 */
	@Test
	void testDefinedIndicator() {
		Integer valueOK = Integer.valueOf(3);
		String valueKO = "KO";

		try {

			log.info("Busco el indicador kkk");
			assertNull(underTest.definedIndicator("kkk", valueOK.getClass().getName()),
					"Deber�a ser nulo, el indicador no est� definido");
			log.info("Busco el indicador watchers");
			assertNotNull(underTest.definedIndicator("watchers", valueOK.getClass().getName()),
					"Deber�a no ser nulo, el indicador est� definido para valor de tipo Integer");
			assertNull(underTest.definedIndicator("watchers", valueKO.getClass().getName()),
					"Deber�a ser nulo, el indicador est� definido para valor de tipo Integer");
		} catch (FileNotFoundException e) {
			fail("El fichero est� en la carpeta resources y no se ha definido uno para la aplicaci�n");
			e.printStackTrace();
		}
		underTest.setAppMetrics("pepe");
		try {
			underTest.definedIndicator("kkk", valueOK.getClass().getName());
			fail("Deber�a lanzar una excepci�n porque intenta buscar en un fichero que no existe");
		} catch (FileNotFoundException e) {
			log.info("Lanza la excepci�n adecuada, FileNotFoud");
		} catch (Exception e) {
			fail("Lanza la excepci�n equivocada " + e);
		}
		//Tendr�a que probar un fichero de configuraci�n de la aplicaci�n cliente que s� fuera v�lido y asegurar que efectivamente se lee

	}
}
