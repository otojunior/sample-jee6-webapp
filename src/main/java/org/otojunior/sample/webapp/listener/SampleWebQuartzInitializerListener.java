/**
 * 
 */
package org.otojunior.sample.webapp.listener;

import javax.servlet.annotation.WebListener;

import org.quartz.ee.servlet.QuartzInitializerListener;

/**
 * Quartz initializer. Could be configured in web.xml, but demonstrated here for
 * demonstrate the use of JEE 6 anotations.
 * @author Oto Junior (otojunior@gmail.com)
 */
@WebListener
public class SampleWebQuartzInitializerListener extends	QuartzInitializerListener { }
