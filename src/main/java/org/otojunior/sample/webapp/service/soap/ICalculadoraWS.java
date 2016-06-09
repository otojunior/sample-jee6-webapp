/**
 * 
 */
package org.otojunior.sample.webapp.service.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author 01456231650
 *
 */
@WebService
public interface ICalculadoraWS {
	@WebMethod public int somar(int x, int y);
	@WebMethod public int subtrair(int x, int y);
	@WebMethod public int multiplicar(int x, int y);
	@WebMethod public double dividir(int x, int y);
}
