package main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Movie {
	@Id	  
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;
	private String Name;
	private String Genre;
	private String Bewertung;
	
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getBewertung() {
		return Bewertung;
	}

	public void setBewertung(String bewertung) {
		Bewertung = bewertung;
	}
}
