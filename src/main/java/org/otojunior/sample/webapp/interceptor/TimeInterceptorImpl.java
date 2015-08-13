/**
 * 
 */
package org.otojunior.sample.webapp.interceptor;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.time.StopWatch;
import org.otojunior.sample.webapp.entity.Tempo;
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
	
	@SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(TimeInterceptorImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@AroundInvoke
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Object invoke(InvocationContext context) throws Exception {
		StopWatch stopWatch = new StopWatch();
		try {
			stopWatch.start();
			return context.proceed();
		} finally {
			stopWatch.stop();
			long miliseconds = stopWatch.getTime();
			
			Tempo tempo = new Tempo();
			tempo.setClasse(context.getTarget().getClass().getName());
			tempo.setMetodo(context.getMethod().getName());
			tempo.setTempo(miliseconds);
			tempo.setData(new Date());
			
			em.persist(tempo);
		}
	}
}
