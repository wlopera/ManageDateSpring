package com.wlopera.spring.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wlopera.spring.domain.AbstractInit;
import com.wlopera.spring.service.ServiceDateApi;
import com.wlopera.spring.wrapper.AbstractWrapper;
import com.wlopera.spring.wrapper.Wrapper;

@Controller
public class DateController {

	@Autowired
	ServiceDateApi service;

	// http://localhost:8585
	@RequestMapping("/")
	public String home() {
		System.out.println("DateController -> home");
		return "index";
	}

	/**
	 * Permite consultar la lista de annios disponibles
	 * 
	 * @return Listado de annios
	 */
	@RequestMapping(value = "/date/dates", method = RequestMethod.GET)
	@ResponseBody
	public AbstractWrapper getDates() {
		System.out.println("DateController -> getDates");
		
		AbstractWrapper wrapper = service.getDates();
		addSelectIntoList(wrapper.getList());
		
		return wrapper;
	}

	/**
	 * Permite consultar la lista de meses
	 * 
	 * @return Listado de meses
	 */
	@RequestMapping(value = "/date/months", method = RequestMethod.GET)
	@ResponseBody
	public AbstractWrapper getMonths() {
		System.out.println("DateController -> getMonths");

		AbstractWrapper wrapper = service.getMonths();
		addSelectIntoList(wrapper.getList());
		
		return wrapper;
	}

	/**
	 * Permite consultar la lista de dias segun el mes y el annio requerido
	 * 
	 * @return Listado de dias disponibles
	 */
	@RequestMapping(value = "/date/days/{year}/{month}", method = RequestMethod.GET)
	@ResponseBody
	public AbstractWrapper getDays(@PathVariable("year") String year, @PathVariable("month") String month) {

		System.out.println("DateController -> getDays");
		System.out.println("DateController -> year: " + year);
		System.out.println("DateController -> month: " + month);

		AbstractWrapper wrapper = service.getDaysByMonth(Integer.valueOf(month), Integer.valueOf(year));
		addSelectIntoList(wrapper.getList());
		
		return wrapper;
		
	}

	// http://localhost:8585/date/nameDay
	@RequestMapping(value = "/date/nameDay/{day}/{month}/{year}", method = RequestMethod.GET)
	@ResponseBody
	public Wrapper getNameDayByDate(@PathVariable("day") String day, @PathVariable("month") String month,
			@PathVariable("year") String year) {

		System.out.println("DateController -> getNameDayByDate");

		Wrapper wrapper = new Wrapper();

		wrapper.setNameDay(
				service.getNameDayByDate(Integer.valueOf(day), Integer.valueOf(month), Integer.valueOf(year)));

		return wrapper;

	}

	// http://localhost:8585/date/now
	@RequestMapping(value = "/date/now", method = RequestMethod.GET)
	public ModelAndView getDateNow() {

		System.out.println("DateController -> getDateNow");

		ModelAndView mav = new ModelAndView("date");

		// Fecha actual - formateada
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		mav.addObject("date", now.format(formatter));

		return mav;

	}

	@RequestMapping("/date/processForm")
	public ModelAndView process(@RequestParam String input) {

		System.out.println("DateController -> process");

		return new ModelAndView("result").addObject("result", input);
	}

	/**
	 * Agregar resgitro selecione (key=-1)
	 * @param list
	 */
	private void addSelectIntoList(List<AbstractInit> list) {
		AbstractInit init = new AbstractInit();
		init.setKey(-1);
		init.setValue("Seleccionar");
		list.add(0, init);
	}
}
