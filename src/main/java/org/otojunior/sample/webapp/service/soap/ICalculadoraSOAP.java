/**
 * 
 */
package org.otojunior.sample.webapp.service.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @author 01456231650
 *
 */
@WebService
@SOAPBinding(style=Style.RPC)
public interface ICalculadoraSOAP {
	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	@WebMethod 
	public Integer somar(
		@WebParam(name="operando1") int x, 
		@WebParam(name="operando2") int y);
	
	@WebMethod public int subtrair(int x, int y);
	@WebMethod public int multiplicar(int x, int y);
	@WebMethod public double dividir(int x, int y);
}
