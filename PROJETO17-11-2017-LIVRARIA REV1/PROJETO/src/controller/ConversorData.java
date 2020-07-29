package controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ConversorData {
	public Date converter(String campodata) {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
		LocalDate data = LocalDate.parse(campodata, formatador);
		System.out.println(data);
		return java.sql.Date.valueOf(data);
	}
}
