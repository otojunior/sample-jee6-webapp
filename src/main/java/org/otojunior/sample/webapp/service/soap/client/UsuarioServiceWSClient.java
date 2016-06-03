/**
 * 
 */
package org.otojunior.sample.webapp.service.soap.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.otojunior.sample.webapp.service.soap.UsuarioServiceWS;

/**
 * @author Cliente WebService SOAP
 *
 */
public class UsuarioServiceWSClient {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://localhost:8080/sample-jee6-webapp/UsuarioServiceWS?wsdl");
		QName qname = new QName("http://service.webapp.sample.otojunior.org/", "UsuarioServiceWSService");
        Service service = Service.create(url, qname);
        UsuarioServiceWS port = service.getPort(UsuarioServiceWS.class);
        System.out.println(port.olaSr("Teste"));
	}
}
