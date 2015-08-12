/**
 * 
 */
package org.otojunior.sample.webapp;

import java.net.URL;
import java.net.URLClassLoader;

import org.apache.log4j.jdbc.JDBCAppender;
import org.apache.log4j.spi.ErrorCode;

/**
 * @author 01456231650
 *
 */
public class TesteAppender extends JDBCAppender {
	@Override
	public void setDriver(String driverClass) {
		try {
			ClassLoader cl = ClassLoader.getSystemClassLoader();
	        URL[] urls = ((URLClassLoader)cl).getURLs();
	        for(URL url: urls) {
	        	String file = url.getFile();
	        	if (file.contains("h2"))
	        		System.out.println(file);
	        }
	        
			Class.forName(driverClass);
		} catch (Exception e) {
			errorHandler.error("Failed to load driver", e,
					ErrorCode.GENERIC_FAILURE);
		}
	}

}
