package com.wlopera.spring.service;

import com.wlopera.spring.wrapper.AbstractWrapper;

public interface ServiceDateApi {
	
	/**
	 * Permite obtener una lista de años
	 * 
	 * @author William Lopera
	 * @return 
	 */
	AbstractWrapper getDates();
	
	/**
	 * Permite obtener la lista de meses del annio
	 * 
	 * @author William Lopera
	 * @return 
	 */
	AbstractWrapper getMonths();
	
	/**
	 * Permite obtener una lista de los dias del mes/annio 
	 * 
	 * @author William Lopera
	 * @return 
	 */
	AbstractWrapper getDays(int year, int month);

	/**
	 * Permite obtener dias de un mes 
	 * 
	 * @author William Lopera
	 * @return 
	 */
	AbstractWrapper getDaysByMonth(int month, int year);

	/**
	 * Permite obtener una lista de años
	 * 
	 * @author William Lopera
	 * @return 
	 */
	String getNameDayByDate(int day, int month, int year);
	
	/**
	 * Permite calcular la cantidad de dias entre dos fechas
	 * 
	 * @author William Lopera
	 * @return 
	 */
	Long getDaysBetWeenDates(String startDate, String endDate);
	
}
