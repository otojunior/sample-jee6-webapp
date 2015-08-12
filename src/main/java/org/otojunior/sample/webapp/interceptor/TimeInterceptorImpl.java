/**
 * 
 */
package org.otojunior.sample.webapp.interceptor;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 01456231650
 *
 */
@Interceptor
@TimeInterceptor
public class TimeInterceptorImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOG = LoggerFactory.getLogger(TimeInterceptorImpl.class);
	
	@AroundInvoke
	public Object invoke(InvocationContext context) throws Exception {
		try {
			LOG.info("Antes proceed");
			return context.proceed();
		} finally {
			LOG.info("Após proceed");
		}
	}
}
