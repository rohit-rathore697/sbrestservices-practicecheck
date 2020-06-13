package com.cognizant.truyum.utill;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.expression.ParseException;

public class DateUtil {
	public static Date convertToDate(String date) throws java.text.ParseException {
		Date dateFormatter = null;
		try {
			dateFormatter = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateFormatter;
	}
}
