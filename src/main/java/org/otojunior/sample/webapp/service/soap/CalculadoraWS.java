/**
 * 
 */
package org.otojunior.sample.webapp.service.soap;

import javax.jws.WebService;

/**
 * @author 01456231650
 *
 */
@WebService
public class CalculadoraWS implements ICalculadoraWS {

	@Override
	public int somar(int x, int y) {
		int r = x + y;
		return r;
	}

	@Override
	public int subtrair(int x, int y) {
		int r = x - y;
		return r;
	}

	@Override
	public int multiplicar(int x, int y) {
		int r = x * y;
		return r;
	}

	@Override
	public double dividir(int x, int y) {
		double xd = (double)x;
		double r = xd / y;
		return r;
	}
}
