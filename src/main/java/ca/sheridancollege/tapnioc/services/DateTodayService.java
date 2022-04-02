package ca.sheridancollege.tapnioc.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class DateTodayService {

	public LocalDate assignTodaysDate(LocalDate date) {
		if (date == null) {
			date = LocalDate.now();
		}
		return date;
	}
}
