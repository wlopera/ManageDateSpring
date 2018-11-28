package com.wlopera.spring.service;

import com.wlopera.spring.wrapper.AbstractWrapper;

public interface ServiceDateApi {
	
	/**
	 * Permite obtener una lista de años
	 * 
	 * @author Willian Lopera
	 * @return 
	 */
	AbstractWrapper getDates();
	
	/**
	 * Permite obtener la lista de meses del annio
	 * 
	 * @author Willian Lopera
	 * @return 
	 */
	AbstractWrapper getMonths();
	
	/**
	 * Permite obtener una lista de los dias del mes/annio 
	 * 
	 * @author Willian Lopera
	 * @return 
	 */
	AbstractWrapper getDays(int year, int month);
	
	/**
	 * Permite obtener una lista de años
	 * 
	 * @author Willian Lopera
	 * @return 
	 */
	String getNameDayByDate(int day, int month, int year);

}
