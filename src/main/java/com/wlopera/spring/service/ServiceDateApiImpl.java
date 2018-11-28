package com.wlopera.spring.service;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.wlopera.spring.domain.AbstractInit;
import com.wlopera.spring.wrapper.AbstractWrapper;

@Service
public class ServiceDateApiImpl implements ServiceDateApi {

	@Override
	public String getNameDayByDate(int day, int month, int year) {

		System.out.println("ServiceDateApiImpl -> getNameDayByDate");

		LocalDate date = LocalDate.of(year, month, day);

		Locale l = new Locale("es", "ES");
		System.out.println(date + " ==> " + date.getDayOfWeek().getDisplayName(TextStyle.FULL, l).toUpperCase());

		return date.getDayOfWeek().getDisplayName(TextStyle.FULL, l).toUpperCase();
	}

	@Override
	public AbstractWrapper getDates() {
		AbstractWrapper wrapper = new AbstractWrapper();
		List<AbstractInit> list = new ArrayList<>();
		AbstractInit init = null;

		for (int i = 0; i < 19; i++) {
			init = new AbstractInit();
			init.setKey(i + 1);
			init.setValue(String.valueOf(2000 + i));
			list.add(init);
		}
		wrapper.setList(list);
		return wrapper;
	}

	@Override
	public AbstractWrapper getMonths() {
		AbstractWrapper wrapper = new AbstractWrapper();
		List<AbstractInit> list = new ArrayList<>();
		AbstractInit init = null;

		List<String> listAux = Arrays.asList("ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO",
				"SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE");
		int key = 1;
		for (String value : listAux) {
			init = new AbstractInit();
			init.setKey(key++);
			init.setValue(value);
			list.add(init);
		}
		wrapper.setList(list);
		return wrapper;
	}

	@Override
	public AbstractWrapper getDays(int year, int month) {
		// TODO Auto-generated method stub
		return null;
	}

	// Para probar
	public static void main(String[] arg) {
		new ServiceDateApiImpl().getNameDayByDate(25, 11, 2018);
	}
}
