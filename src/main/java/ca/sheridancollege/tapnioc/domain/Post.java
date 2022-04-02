package ca.sheridancollege.tapnioc.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ca.sheridancollege.tapnioc.services.DateTodayService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Post {
	
	@Transient
	@JsonIgnore
	private DateTodayService dateTodayService = new DateTodayService();
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String author;
	
	@NonNull
	private String heading;
	
	@NonNull
	@Lob
	private String body;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	private LocalDate date; 
	
	public void setDate(LocalDate date) {
		this.date = dateTodayService.assignTodaysDate(date); 
	}
	
	public Post(@NonNull String author, @NonNull String heading, @NonNull String body, LocalDate date) {
		this.author = author;
		this.heading = heading;
		this.body = body;
		this.date = dateTodayService.assignTodaysDate(date);  
	}
}
